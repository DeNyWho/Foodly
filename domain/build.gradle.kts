plugins {
    alias(libs.plugins.foodly.android.library.compose)
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.koin)
}

android {
    namespace = "com.example.foodly.domain"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    api(libs.androidx.compose.runtime)
    implementation(libs.paging.runtime)
    implementation(libs.kotlinx.serialization.json)
}