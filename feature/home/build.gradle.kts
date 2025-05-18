plugins {
    alias(libs.plugins.foodly.android.feature)
    alias(libs.plugins.foodly.android.library.compose)
}

android {
    namespace = "com.example.foodly.feature.home"
}

dependencies {
    testImplementation(libs.hilt.android.testing)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
