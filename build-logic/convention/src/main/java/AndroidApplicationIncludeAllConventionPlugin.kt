import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("unused")
class AndroidApplicationIncludeAllConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            // 테스트 작업(Unit Test 등) 실행 시에만 모든 모듈을 참조하도록 'testImplementation'을 사용합니다.
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
        }
    }
}
