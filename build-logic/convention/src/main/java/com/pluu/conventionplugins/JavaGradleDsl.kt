package com.pluu.conventionplugins

import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.JavaPluginExtension

internal fun Project.`java`(
    configure: Action<JavaPluginExtension>
) {
    (this as ExtensionAware).extensions.configure("java", configure)
}