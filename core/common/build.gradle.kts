plugins {
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.koin)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.foodly.core.common"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {

    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}