// SDK
val projectCompileSdk: Int by rootProject.extra
val projectMinSdk: Int by rootProject.extra
val projectTargetSdk: Int by rootProject.extra

// Material
val coreVersion: String by rootProject.extra
val appcompatVersion: String by rootProject.extra
val materialVersion: String by rootProject.extra

// Kotlin
val kotlinVersion: String by rootProject.extra

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.sephoratest.core"
    compileSdk = projectCompileSdk

    defaultConfig {
        minSdk = projectMinSdk
        targetSdk = projectTargetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:$coreVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("com.google.android.material:material:1.7.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}