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

val ViewManager.context
    get() = when (this) {
        is View -> context
        is ActivityViewManager -> activity
        else -> TODO()
    }

class ActivityViewManager(val activity: Activity) : ViewManager {
    override fun addView(p0: View?, p1: ViewGroup.LayoutParams?) {
        activity.setContentView(p0)
    }

    override fun updateViewLayout(p0: View?, p1: ViewGroup.LayoutParams?) {
        TODO("not implemented")
    }

    override fun removeView(p0: View?) {
        TODO("not implemented")
    }
}

inline fun Activity.setContentView(
    ui: ViewManager.() -> Unit
) = ActivityViewManager(this).apply(ui)

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