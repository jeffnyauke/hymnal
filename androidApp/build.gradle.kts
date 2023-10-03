plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.compose)
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.github.jeffnyauke.hymnal"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    val jdkVersion = findProperty("kotlin.jdkVersion") as String

    defaultConfig {
        applicationId = "com.github.jeffnyauke.hymnal"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = (findProperty("android.versionCode") as String).toInt()
        versionName = findProperty("android.versionName") as String
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(jdkVersion)
        targetCompatibility = JavaVersion.toVersion(jdkVersion)
    }
    kotlin {
        jvmToolchain(jdkVersion.toInt())
    }
}
