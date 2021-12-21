package com.avancera.mvvmarchitectureapp.models.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseGeneral<T>(
    @Json(name = "errors")
    val errors: List<String>? = arrayListOf(),
    @Json(name = "message")
    val message: List<String>? = arrayListOf(),
    @Json(name = "status")
    val status_code: Int = 0,
    @Json(name = "data")
    var data: T,

//    @Json(name = "exception")
//    val exception: String? = null
)