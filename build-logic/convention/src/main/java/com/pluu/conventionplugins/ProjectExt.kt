package com.pluu.conventionplugins

import org.gradle.api.Project

val Project.isRoot get() = this == rootProject