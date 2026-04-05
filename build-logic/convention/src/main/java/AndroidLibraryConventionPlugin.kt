import com.android.build.api.dsl.LibraryExtension
import com.pluu.conventionplugins.configureBuildTypes
import com.pluu.conventionplugins.configureKotlin
import com.pluu.conventionplugins.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid()
                configureBuildTypes()
                configureKotlin()

                defaultConfig.consumerProguardFiles("consumer-rules.pro")
            }
        }
    }
}