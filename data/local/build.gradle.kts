plugins {
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.koin)
    alias(libs.plugins.foodly.android.room)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.foodly.data.local"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
    implementation(projects.domain)
    implementation(libs.paging.runtime)
    implementation(libs.room.paging)

    testImplementation(libs.junit)
}