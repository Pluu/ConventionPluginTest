package com.pluu.conventionplugins

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import java.util.*

internal fun <T : Any> DependencyHandlerScope.kapt(
    dependencyNotation: Optional<Provider<T>>
) {
    dependencies.add("kapt", dependencyNotation.get())
}

internal fun Project.`kapt`(
    configure: Action<KaptExtension>
) {
    (this as ExtensionAware).extensions.configure("kapt", configure)
}
