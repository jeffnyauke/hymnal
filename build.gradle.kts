plugins {
    alias(libs.plugins.org.jetbrains.kotlin.multiplatform) apply false
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.com.android.library) apply false
    alias(libs.plugins.org.jetbrains.compose) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
