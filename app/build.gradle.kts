plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.kotlin.compose)
  alias(libs.plugins.kapt)
  alias(libs.plugins.hilt)
  alias(libs.plugins.kotlinSerialization)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.mahi.kitmanlabs"
  compileSdk {
    version = release(36)
  }

  defaultConfig {
    applicationId = "com.mahi.kitmanlabs"
    minSdk = 24
    targetSdk = 36
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
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
  kotlin {
    jvmToolchain(11)
  }
  buildFeatures {
    compose = true
  }
}

dependencies {
  //Android X
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.compose.material.icons.extended)
  implementation(libs.androidx.activity.compose)

  //Compose
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.compose.ui)
  implementation(libs.androidx.compose.ui.graphics)
  implementation(libs.androidx.compose.ui.tooling.preview)
  debugImplementation(libs.androidx.compose.ui.tooling)
  implementation(libs.androidx.compose.material3)


  //CoRoutines
  implementation(libs.coroutines.android)

  //Hilt
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)

  //KotlinX Serialization
  implementation(libs.kotlinx.serialization.json)
  implementation(libs.kotlinx.serialization.converter)

  //Retrofit
  implementation(libs.retrofit)
  implementation(libs.okhttp)
  implementation(libs.okhttp.logging)

  //Coil
  implementation(libs.coil.compose)
  implementation(libs.coil.network.okhttp)

  // Room DB
  implementation(libs.androidx.room.runtime)
  ksp(libs.androidx.room.compiler)
  implementation(libs.androidx.room.ktx)

  // Navigation
  implementation(libs.androidx.navigation.compose)
  implementation(libs.androidx.hilt.navigation.compose)

  //Testing
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.compose.ui.test.junit4)
  debugImplementation(libs.androidx.compose.ui.test.manifest)
}