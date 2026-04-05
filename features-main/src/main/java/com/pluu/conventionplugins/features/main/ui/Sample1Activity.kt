package com.pluu.conventionplugins.features.main.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pluu.sample.column
import com.pluu.sample.setContentView
import com.pluu.sample.text
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Sample1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView {
            column {
                text("Main-Sample1Activity")
            }
        }
    }
}