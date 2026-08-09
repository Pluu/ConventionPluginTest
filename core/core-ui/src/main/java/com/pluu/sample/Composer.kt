package com.pluu.sample

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

val ViewManager.context
    get() = when (this) {
        is View -> context
        is ActivityViewManager -> activity
        else -> TODO()
    }

class ActivityViewManager(val activity: Activity) : ViewManager {
    override fun addView(view: View, params: ViewGroup.LayoutParams) {
        view.id = View.generateViewId()
        activity.setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(activity.findViewById(view.id)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun updateViewLayout(view: View, p1: ViewGroup.LayoutParams) {
        TODO("not implemented")
    }

    override fun removeView(view: View) {
        TODO("not implemented")
    }
}

inline fun Activity.setContentView(
    ui: ViewManager.() -> Unit
) = ActivityViewManager(this).apply(ui).apply {

}

fun <VM : ViewManager, V : View> VM.add(
    construct: (Context) -> V,
    init: V.() -> Unit
) {
    construct(context).apply(init).also {
        addView(it, ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT))
    }
}

fun ViewManager.column(
    init: LinearLayout.() -> Unit
) {
    add(::LinearLayout) {
        orientation = LinearLayout.VERTICAL
        init()
    }
}

fun ViewManager.button(
    text: String,
    listener: (View) -> Unit
) {
    add(::Button) {
        this.text = text
        setOnClickListener(listener)
    }
}

fun ViewManager.text(
    text: String
) {
    add(::TextView) {
        this.text = text
    }
}