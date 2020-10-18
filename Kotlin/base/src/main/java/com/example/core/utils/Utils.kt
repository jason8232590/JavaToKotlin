@file:JvmName("kotlinUtils")
package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics;

//扩展函数
fun  Float.dp2px(): Float{
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics);
}

fun toast(string: String , duration: Int = Toast.LENGTH_SHORT ) {
    Toast.makeText(BaseApplication.currentApplication, string, duration).show();
}