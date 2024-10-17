plugins {
    alias(libs.plugins.android.gradle)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.papslabs.omdb_kmp.android"
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = getVersionCode()
        versionName = getVersionName()
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    signingConfigs {
        create("config") {
            storeFile = file(project.property("STORE_PATH") as String)
            storePassword = project.property("STORE_PASSWORD") as String
            keyAlias = project.property("KEY_ALIAS") as String
            keyPassword = project.property("KEY_PASSWORD") as String
        }
    }
    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("config")
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            signingConfig = signingConfigs.getByName("config")
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = getJavaVersion()
        targetCompatibility = getJavaVersion()
    }
    kotlinOptions {
        jvmTarget = getJavaVersion().toString()
    }
}

dependencies {
    implementation(projects.shared)

    implementation(libs.androidx.core)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)

    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(libs.coil)
}

fun getVersionCode(): Int {
    val major = libs.versions.major.get().toInt() * 100000
    val minor = libs.versions.minor.get().toInt() * 100
    val hotfix = libs.versions.hotfix.get().toInt()
    return 100000000 + major + minor + hotfix
}

fun getVersionName(): String {
    val major = libs.versions.major.get()
    val minor = libs.versions.minor.get()
    val hotfix = libs.versions.hotfix.get()
    return "$major.$minor.$hotfix"
}

fun getJavaVersion(): JavaVersion = JavaVersion.VERSION_21