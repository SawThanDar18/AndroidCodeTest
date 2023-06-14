package com.sawthandar.androidcodetest.util

import android.content.Context
import android.content.SharedPreferences
import com.sawthandar.androidcodetest.R

object SessionManager {
    private const val USER_KEY_ID = "user_key_id"

    fun saveUserKeyId(context: Context, userKeyId: String) {
        saveString(context, USER_KEY_ID, userKeyId)
    }

    fun getUserKeyId(context: Context): String? {
        return getString(context, USER_KEY_ID)
    }

    private fun saveString(context: Context, key: String, value: String) {
        val preferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    private fun getString(context: Context, key: String): String? {
        val preferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
        return preferences.getString(this.USER_KEY_ID, null)
    }

    fun clearData(context: Context) {
        val editor = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE).edit()
        editor.clear()
        editor.apply()
    }
}