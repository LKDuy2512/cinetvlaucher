
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "vn.cinevn.cinetv"
    compileSdk = 35

    defaultConfig {
        applicationId = "vn.cinevn.cinetv"
        minSdk = 23
        targetSdk = 28
        versionCode = 1
        versionName = "1.0"
    }
}
