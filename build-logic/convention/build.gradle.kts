plugins {
    `kotlin-dsl`
}

group = "com.pluu.convention.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "pluu.convention.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "pluu.convention.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "pluu.convention.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "pluu.convention.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("javaLibrary") {
            id = "pluu.convention.java"
            implementationClass = "JavaLibraryConventionPlugin"
        }
    }
}