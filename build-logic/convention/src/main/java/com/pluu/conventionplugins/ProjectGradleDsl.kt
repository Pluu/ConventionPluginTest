package com.pluu.conventionplugins

import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import java.util.*

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