// SDK
val projectCompileSdk by extra(33)
val projectMinSdk by extra(23)
val projectTargetSdk by extra(33)

// Android X
val coreVersion by extra("1.9.0")
val appcompatVersion by extra("1.5.0")
val materialVersion by extra("1.7.0")

// Kotlin
val kotlinVersion by extra("1.8.0")

// Compose
val composeVersion by extra("1.3.3")

plugins {
    id("com.android.application") version "7.3.1" apply false
    id("com.android.library") version "7.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}
