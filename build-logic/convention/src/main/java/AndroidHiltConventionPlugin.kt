import com.pluu.conventionplugins.implementation
import com.pluu.conventionplugins.ksp
import com.pluu.conventionplugins.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                apply("dagger.hilt.android.plugin")
            }

            dependencies {
                // Hilt
                implementation(libs.findLibrary("hilt-android"))
                ksp(libs.findLibrary("hilt-compiler"))
            }
        }
    }
}