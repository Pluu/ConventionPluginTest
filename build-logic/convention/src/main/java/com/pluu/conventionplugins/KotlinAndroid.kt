@file:Suppress("UnstableApiUsage")

package com.pluu.conventionplugins

import Const
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
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
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

fun Project.configureKotlin() {
    extensions.configure<KotlinAndroidProjectExtension> {
        compilerOptions {
            configureDefaultKotlinOption()
        }
    }
}

fun Project.configureKotlinLibrary() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            configureDefaultKotlinOption()
        }
    }
}

private fun KotlinJvmCompilerOptions.configureDefaultKotlinOption() {
    allWarningsAsErrors.set(true)
//    optIn.addAll()

    // Set JVM target
    jvmTarget.set(Const.JVM_TARGET)
}
