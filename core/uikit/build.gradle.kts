plugins {
    alias(libs.plugins.foodly.android.library.compose)
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.koin)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.foodly.core.uikit"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    lintPublish(projects.lint)
    implementation(projects.domain)

    api(libs.kotlinx.collections.immutable)
    api(libs.airbnb.lottie)
    api(libs.paging.runtime)
    api(libs.paging.compose)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.core.ktx)

    api(libs.shimmer.compose)

    api(libs.coil.kt.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}