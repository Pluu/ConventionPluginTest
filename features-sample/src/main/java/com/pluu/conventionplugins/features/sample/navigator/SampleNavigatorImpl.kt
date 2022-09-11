package com.pluu.conventionplugins.features.sample.navigator

import android.app.Activity
import com.pluu.conventionplugins.features.common.SampleNavigator
import com.pluu.conventionplugins.features.sample.ui.FeaturesSample1Activity
import com.pluu.sample.startActivity
import javax.inject.Inject

internal class SampleNavigatorImpl @Inject constructor() : SampleNavigator {
    override fun start(activity: Activity) {
        activity.startActivity<FeaturesSample1Activity>()
    }
}