plugins {
    alias(libs.plugins.androidApplication)
    id("org.jetbrains.kotlin.android")

    kotlin("plugin.serialization") version "1.5.10"

}


android {
    namespace = "com.example.oechappfinal"
    compileSdk = 34

    kotlinOptions {
        jvmTarget = "1.8" // или любая другая совместимая версия с вашими Java-файлами
    }




    defaultConfig {
        applicationId = "com.example.oechappfinal"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("androidx.core:core-ktx:+")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.google.android.material:material:1.11.0")
    implementation("io.github.jan-tennert.supabase:postgrest-kt:0.7.6")
    implementation("io.ktor:ktor-client-cio:2.3.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0-RC")
}