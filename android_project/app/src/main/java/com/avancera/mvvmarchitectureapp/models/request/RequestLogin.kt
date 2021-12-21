package com.avancera.mvvmarchitectureapp.models.request

import com.squareup.moshi.Json

data class RequestLogin(
    @Json(name = "email")
    val email: String? = null,
    @Json(name = "password")
    val password: String? = null
)
