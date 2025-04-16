plugins {
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.foodly.data.source"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.domain)
    implementation(projects.data.network)
    implementation(projects.data.datastore)
    implementation(projects.data.local)

    implementation(libs.paging.runtime)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
}