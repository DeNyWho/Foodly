plugins {
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.koin)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.secrets)
}

android {
    namespace = "com.example.foodly.data.datastore"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.domain)
    implementation(libs.kotlinx.serialization.protobuf)
    implementation(libs.androidx.dataStore.core)
    implementation(libs.androidx.dataStore.preferences)
    testImplementation(libs.junit)
}