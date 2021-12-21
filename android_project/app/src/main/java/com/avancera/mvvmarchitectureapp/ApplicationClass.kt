package com.avancera.mvvmarchitectureapp

import android.app.Application

class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()

        mApplicationClass = this
    }


    companion object {

        @JvmStatic
        private lateinit var mApplicationClass: ApplicationClass

        val application : ApplicationClass by lazy {

            mApplicationClass

        }

    }

}