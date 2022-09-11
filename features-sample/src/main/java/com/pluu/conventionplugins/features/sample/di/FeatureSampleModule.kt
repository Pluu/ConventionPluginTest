package com.pluu.conventionplugins.features.sample.di

import com.pluu.conventionplugins.features.common.SampleNavigator
import com.pluu.conventionplugins.features.sample.navigator.SampleNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@InstallIn(SingletonComponent::class)
@Module
internal abstract class FeatureSampleModule {
    @Binds
    abstract fun bindNavigator(
        navigator: SampleNavigatorImpl
    ): SampleNavigator
}