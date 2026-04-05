package com.pluu.conventionplugins

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import java.util.Optional

internal fun <T : Any> DependencyHandlerScope.implementation(
    dependencyNotation: Optional<Provider<T>>
) {
    implementation(dependencyNotation.get())
}

internal fun DependencyHandlerScope.implementation(
    dependencyNotation: Any
) {
    dependencies.add("implementation", dependencyNotation)
}

internal fun <T : Any> DependencyHandler.ksp(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("ksp", dependencyNotation.get())