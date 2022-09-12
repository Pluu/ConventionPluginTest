import com.pluu.conventionplugins.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("pluu.convention.android.library")
                apply("pluu.convention.android.hilt")
            }

            dependencies {
                implementation(project(":core-ui"))
                implementation(project(":features-navigator"))
            }
        }
    }
}