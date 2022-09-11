package com.pluu.conventionplugins.features.main.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.conventionplugins.features.common.SampleNavigator
import com.pluu.sample.button
import com.pluu.sample.column
import com.pluu.sample.setContentView
import com.pluu.sample.startActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigator: SampleNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView {
            column {
                button("Go, Inner sample Activity") {
                    startActivity<Sample1Activity>()
                }
                button("Go, Feature sample Activity") {
                    navigator.start(this@MainActivity)
                }
            }
        }
    }
}