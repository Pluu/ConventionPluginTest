plugins {
    id("pluu.convention.android.feature")
}

android {
    namespace = "com.pluu.conventionplugins.features.main"
}

dependencies {
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit4)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
}