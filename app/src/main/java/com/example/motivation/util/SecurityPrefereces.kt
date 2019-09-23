package com.example.motivation.util

import android.content.Context
import android.content.SharedPreferences

class SecurityPrefereces(context: Context) {
    private val mSharedPrefereces: SharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        mSharedPrefereces.edit().putString(key, value).apply()
    }
    fun getStoredString(key: String): String? {
        return mSharedPrefereces.getString(key,"")
    }
}