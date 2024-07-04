plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.coding.data"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.coding.data"
        minSdk = 29
        targetSdk = 34
        compileSdk = 34
        versionCode = 1
    }
}

dependencies {
    implementation(project(":domain"))

    // Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.benchmark.common)
    implementation(libs.androidx.runtime.android)
    implementation(project(":core"))
    kapt(libs.hilt.compiler)

    // ViewModel và LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    implementation(libs.coil)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.material3)
    implementation(libs.coil.compose)
    implementation(libs.androidx.ui.v154)
    implementation(libs.androidx.activity.compose)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}