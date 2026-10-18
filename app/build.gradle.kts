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
        targetSdk = 28 // Lưu ý: targetSdk nên được nâng lên bằng compileSdk (35) để phù hợp với quy định mới của Google Play Store
        versionCode = 1
        versionName = "1.0"
    }

    // Thêm đoạn này để đồng bộ JVM target về phiên bản 17
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}
