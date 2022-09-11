import com.pluu.conventionplugins.implementation
import com.pluu.conventionplugins.kapt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

@Suppress("unused")
class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-kapt")
                apply("dagger.hilt.android.plugin")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                // Hilt
                implementation(libs.findLibrary("hilt-android"))
                kapt(libs.findLibrary("hilt-compiler"))
            }

            kapt {
                correctErrorTypes = true
            }
        }
    }
}