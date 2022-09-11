import com.pluu.conventionplugins.isRoot
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

@Suppress("unused")
class ProjectRootConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        if (!project.isRoot) return
        project.configureRootProject()
    }

    private fun Project.configureRootProject() {
        // Create ExtraProperties
        extra.set("PLUU", "izumi konata")
    }
}