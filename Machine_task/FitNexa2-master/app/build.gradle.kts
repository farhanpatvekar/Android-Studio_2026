plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.example.fitnexa2"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.fitnexa2"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:3.0.0")

    implementation("com.squareup.retrofit2:converter-gson:3.0.0")

    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.firebase.auth)

    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}