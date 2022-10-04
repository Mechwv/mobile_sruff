import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

val y_key = gradleLocalProperties(rootDir).getProperty("YANDEX_API_KEY")

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.weatherappcompose"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
//        buildConfigField("String", "YANDEX_API_KEY", localProperties["YANDEX_API_KEY"])

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            buildConfigField("String", "YANDEX_API_KEY", y_key)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
        isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjvm-default=all-compatibility")
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    hilt { enableAggregatingTask = true }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.compose.ui:ui:${Deps.compose_version}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Deps.compose_version}")

    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.material:material:${Deps.compose_version}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Deps.compose_version}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Deps.compose_version}")

    //I will name them someday
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.fragment:fragment-ktx:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    //Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Deps.compose_version}")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.1.0")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:${Deps.hilt_version}")
    kapt("com.google.dagger:hilt-compiler:${Deps.hilt_version}")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Architectural Components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    //Coroutine Lifecycle Scopes
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    //Material
    implementation("androidx.compose.material3:material3:1.0.0-alpha01")

    //Desugaring
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.1")

    //Room
    implementation("androidx.room:room-runtime:${Deps.room_version}")
    implementation("androidx.room:room-ktx:${Deps.room_version}")
    kapt("androidx.room:room-compiler:${Deps.room_version}")

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
}