import com.android.build.api.dsl.ApplicationExtension
import com.pluu.conventionplugins.configureBuildTypes
import com.pluu.conventionplugins.configureKotlin
import com.pluu.conventionplugins.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.application")
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    targetSdk = 33
                }
                configureKotlinAndroid()
                configureBuildTypes()
                configureKotlin()
            }
        }
    }
}