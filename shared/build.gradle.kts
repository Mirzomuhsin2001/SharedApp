plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

group = "com.muhsin.mysharedlib"
version = "1.0.0"

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
    }
}

publishing {
    repositories {
        maven {
            setUrl("https://maven.pkg.github.com/Mirzomuhsin2001/SharedApp")
            credentials {
                username = "Mirzomuhsin2001"
                password = "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"
            }
        }
    }
}

android {
    namespace = "com.example.sharedapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 21
    }
}