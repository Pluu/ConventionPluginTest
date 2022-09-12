import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.pluu.conventionplugins.configureBuildTypes
import com.pluu.conventionplugins.configureKotlin
import com.pluu.conventionplugins.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused", "UnstableApiUsage")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid()
                configureBuildTypes()
                configureKotlin(project)
            }
        }
    }
}