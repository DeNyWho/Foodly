plugins {
    alias(libs.plugins.foodly.android.feature)
    alias(libs.plugins.foodly.android.library.compose)
}

android {
    namespace = "com.example.foodly.feature.favourite"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
