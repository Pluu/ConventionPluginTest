package com.pluu.sample

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(
        Intent(this, T::class.java)
    )
}