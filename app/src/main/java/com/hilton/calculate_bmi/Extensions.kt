package com.hilton.calculate_bmi

import android.app.Activity
import android.view.View
import android.view.View.*
import android.webkit.RenderProcessGoneDetail
import android.widget.EditText
import android.widget.Toast


fun EditText.get() = text.toString().trim()
fun EditText.validate() = text.toString().trim().isEmpty()
fun Activity.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG)
    .show()
fun View.gone(){
    visibility = GONE
}
fun View.visible(){
    visibility = VISIBLE
}
fun View.invisible(){
    visibility = INVISIBLE
}