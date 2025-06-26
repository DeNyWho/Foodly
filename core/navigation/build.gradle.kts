plugins {
    alias(libs.plugins.foodly.android.library)
    alias(libs.plugins.foodly.android.koin)

}

android {
    namespace = "com.example.foodly.core.navigation"
}

dependencies {
    api(libs.voyager.navigator)
    api(libs.voyager.screenmodel)
    api(libs.voyager.bottomsheet)
    api(libs.voyager.transitions)
    api(libs.voyager.koin)
}