package com.example.core.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.core.BaseApplication
import com.example.core.R

object CacheUtils {

    private val context   = BaseApplication.currentApplication;

    val SP: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE);

    fun save(key: String , value: String ) {
        SP.edit().putString(key, value).apply();
    }

    fun get(key: String? ) = SP.getString(key, null);

}