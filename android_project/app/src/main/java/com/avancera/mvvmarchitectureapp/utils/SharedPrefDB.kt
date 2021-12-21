package com.avancera.mvvmarchitectureapp.utils

import android.preference.PreferenceManager
import com.avancera.mvvmarchitectureapp.ApplicationClass

class SharedPrefDB private constructor(){

    private val preferences by lazy {

        PreferenceManager.getDefaultSharedPreferences(ApplicationClass.application.applicationContext)

    }


    companion object {

        val instance by lazy { SharedPrefDB() }

    }


    fun putString(key: String, value: String) {
        checkForNullKey(key)
        checkForNullValue(value)
        preferences.edit().putString(key, value).apply()
    }


    fun checkForNullKey(key: String?) {
        if (key == null) {
            throw NullPointerException()
        }
    }

    /**
     * null keys would corrupt the shared pref file and make them unreadable this is a preventive measure
     * @param value pref key
     */
    fun checkForNullValue(value: String?) {
        if (value == null) {
            throw NullPointerException()
        }
    }

    fun getString(key: String): String {
        return preferences.getString(key, "") ?: ""
    }

}