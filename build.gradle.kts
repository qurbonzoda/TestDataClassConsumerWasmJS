import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform") version "2.1.255-SNAPSHOT"
    `maven-publish`
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {

}

kotlin {
    jvmToolchain(8)

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        nodejs()
    }

    sourceSets {
        commonMain {
            dependencies {
                api("org.jetbrains.kotlin:kotlin-stdlib:2.1.255-SNAPSHOT")
            }
        }
        commonTest {
            dependencies {
                api("org.jetbrains.kotlin:kotlin-test:2.1.255-SNAPSHOT")
            }
        }
        wasmJsTest {
            dependsOn(commonTest.get())
            dependencies {
                api("org.example:TestDataClassWasmJS:1.0-SNAPSHOT")
            }
        }
    }
}