plugins {
    alias(libs.plugins.foodly.android.application)
    alias(libs.plugins.foodly.android.application.compose)
    alias(libs.plugins.foodly.android.koin)
}

android {
    namespace = "com.example.foodly"

    defaultConfig {
        applicationId = "com.example.foodly"
        versionCode = 1
        versionName = "0.1.1"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("/META-INF/DEPENDENCIES")
            excludes.add("/META-INF/INDEX.LIST")
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    // feature
    implementation(projects.feature.favourite)
    implementation(projects.feature.home)
    implementation(projects.feature.search)
    implementation(projects.feature.explore)
    implementation(projects.feature.detail)

    // data
    implementation(projects.data.datastore)
    implementation(projects.data.local)
    implementation(projects.data.network)
    implementation(projects.data.source)

    implementation(projects.domain)
    implementation(projects.data.source)

    implementation(projects.core.uikit)
    implementation(projects.core.common)
    implementation(projects.core.navigation)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtimeCompose)
    implementation(libs.androidx.tracing.ktx)
    implementation(libs.kotlinx.coroutines.guava)

    debugImplementation(libs.androidx.compose.ui.testManifest)

    androidTestImplementation(libs.androidx.test.espresso.core)
}

dependencyGuard {
    configuration("releaseRuntimeClasspath")
}