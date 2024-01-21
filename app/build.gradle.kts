@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.serialization)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.application.android)
    alias(libs.plugins.detekt)
}

android {
    compileSdk = 34
    namespace = "com.bed.ohhferta"

    defaultConfig {
        applicationId = "com.bed.ohhferta"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        vectorDrawables {
            useSupportLibrary = true
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("Boolean", "IS_DEBUG", "true")
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }

        register("profile") {
            isMinifyEnabled = true
            isShrinkResources = true
            applicationIdSuffix = ".profile"
            initWith(getByName("debug"))
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules-staging.pro"
            )
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compiler.get()
    }
}

dependencies {
    implementation(project(":core"))

    implementation(libs.bundles.app)
    implementation(libs.bundles.ktx)
    implementation(libs.bundles.ktor)
    implementation(libs.bundles.compose)

    detektPlugins(libs.detekt)

    testImplementation(project(":test"))

    androidTestImplementation(libs.bundles.android.test)
    androidTestImplementation(platform(libs.ui.compose))

    debugImplementation(libs.bundles.debug)
}

detekt {
    toolVersion = libs.versions.detekt.get()

    parallel = true

    debug = false
    allRules = false
    ignoreFailures = false
    buildUponDefaultConfig = false
    disableDefaultRuleSets = false

    basePath = projectDir.absolutePath
    ignoredBuildTypes = listOf("release")
    config.setFrom(file("$rootDir/config/detekt/detekt.yml"))
    source.setFrom(
        "$rootDir/app/src/main/java",
        "$rootDir/app/src/test/java",
        "$rootDir/app/src/androidTest/java",
        "$rootDir/core/src/main/java",
        "$rootDir/core/src/test/java",
        "$rootDir/test/src/main/java"
    )
}

afterEvaluate {
    tasks.named("preBuild") {
        dependsOn("detekt")
    }
}

tasks.detekt.configure {
    reports {
        sarif.required.set(true)
    }
}
