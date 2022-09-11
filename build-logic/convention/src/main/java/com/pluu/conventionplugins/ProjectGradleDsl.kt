package com.pluu.conventionplugins

import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import java.util.*

internal fun <T : Any> DependencyHandlerScope.implementation(
    dependencyNotation: Optional<Provider<T>>
) {
    dependencies.add("implementation", dependencyNotation.get())
}