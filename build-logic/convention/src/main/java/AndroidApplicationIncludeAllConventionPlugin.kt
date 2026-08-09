import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidApplicationIncludeAllConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // 실행하려는 태스크 이름에 "test" 또는 "connected"가 포함된 경우에만 의존성을 추가합니다.
            val isTestTaskRequested = gradle.startParameter.taskNames.any {
                it.endsWith("testDebugUnitTest", ignoreCase = true) ||
                        it.endsWith("connectedDebugAndroidTest", ignoreCase = true)
            }

            if (!isTestTaskRequested) return

            println(">>> Start AndroidApplicationIncludeAllConventionPlugin")
            rootProject.subprojects
                .filter { it != this } // 현재 프로젝트(app) 제외
                .filter { it.buildFile.exists() } // 실제 빌드 파일이 존재하는 프로젝트만
                .filter { !it.path.startsWith(":sample") }
                .forEach { subproject ->
                    println(">>> ${subproject.path}")
                    dependencies {
                        // 로컬 단위 테스트용
                        "testImplementation"(project(subproject.path))
                        // 기기/에뮬레이터 UI 테스트용
                        "androidTestImplementation"(project(subproject.path))
                    }
                }
            println(">>> End AndroidApplicationIncludeAllConventionPlugin")
        }
    }
}
