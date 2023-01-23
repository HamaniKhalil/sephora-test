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

// Compose
val composeVersion: String by rootProject.extra

// DI
val daggerHiltVersion: String by rootProject.extra

// Retrofit
val retrofitVersion: String by rootProject.extra

kapt {
    correctErrorTypes = true
}


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.sephoratest"
    compileSdk = projectCompileSdk

    defaultConfig {
        applicationId = "com.sephoratest"
        minSdk = projectMinSdk
        targetSdk = projectTargetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        version = kotlinVersion
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":network"))

    implementation("androidx.core:core:$appcompatVersion")
    implementation("androidx.core:core-ktx:$appcompatVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material:material:1.3.1")

    // Optional - Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // Optional - Integration with LiveData
    implementation("androidx.compose.runtime:runtime-livedata:1.4.0-alpha04")
    // Swipe refresh
    implementation("com.google.accompanist:accompanist-swiperefresh:0.27.0")
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")

    // DI
    implementation("com.google.dagger:hilt-android:$daggerHiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerHiltVersion")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    // Okhttp
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}