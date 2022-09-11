package com.pluu.conventionplugins.features.sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pluu.sample.*

class FeaturesSample1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView {
            column {
                text("Features-Sample1Activity")
            }
        }
    }
}