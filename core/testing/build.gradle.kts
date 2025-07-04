plugins {
    alias(libs.plugins.foodly.android.library)
}

android {
    namespace = "com.example.foodly.core.testing"
}

dependencies {
    api(kotlin("test"))
    api(libs.androidx.compose.ui.test)
    api(projects.core.common)
    api(projects.core.uikit)

    debugApi(libs.androidx.compose.ui.testManifest)

    implementation(libs.androidx.test.rules)
    implementation(libs.kotlinx.coroutines.test)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}