@file:Suppress("UnstableApiUsage")

package com.pluu.conventionplugins

import Const
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure base Kotlin with Android options
 */
fun CommonExtension.configureKotlinAndroid() {
    compileSdk = Const.compileSdk

    defaultConfig.apply {
        minSdk = Const.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions.apply {
        sourceCompatibility = Const.JAVA_VERSION
        targetCompatibility = Const.JAVA_VERSION
    }
}

fun CommonExtension.configureBuildTypes() {
    buildTypes.apply {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            allWarningsAsErrors.set(true)

            optIn.addAll(
                "-opt-in=kotlin.RequiresOptIn",
                // Enable experimental coroutines APIs, including Flow
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-opt-in=kotlinx.coroutines.FlowPreview",
                "-opt-in=kotlin.Experimental",
                // Enable experimental kotlinx serialization APIs
                "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
            )

            // Set JVM target
            jvmTarget.set(Const.JVM_TARGET)
        }
    }
}
