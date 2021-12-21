package com.avancera.mvvmarchitectureapp.models.response


import com.squareup.moshi.Json

data class LoginResponseModel(

        @Json(name = "active")
        val active: Boolean,
        @Json(name = "activeSubscriptionId")
        val activeSubscriptionId: String,
        @Json(name = "cashToWithdraw")
        val cashToWithdraw: Int,
        @Json(name = "city")
        val city: String,
        @Json(name = "couponUsed")
        val couponUsed: Int,
        @Json(name = "createdAt")
        val createdAt: String,
        @Json(name = "credits")
        val credits: Double,
        @Json(name = "customerId")
        val customerId: String,
        @Json(name = "email")
        val email: String,
        @Json(name = "fullName")
        val fullName: String,
        @Json(name = "_id")
        val id: String,
        @Json(name = "limitPerCategory")
        val limitPerCategory: Int,
        @Json(name = "phoneNumber")
        val phoneNumber: String,
        @Json(name = "profileImage")
        val profileImage: String,
        @Json(name = "referalKey")
        val referalKey: String,
        @Json(name = "refrenceType")
        val refrenceType: Int,
        @Json(name = "subscriptionRenewalDate")
        val subscriptionRenewalDate: String,
        @Json(name = "subscriptionTimeLeft")
        val subscriptionTimeLeft: String,
        @Json(name = "token")
        val token: String,
        @Json(name = "trial")
        val trial: Boolean,
        @Json(name = "type")
        val type: Int,
        @Json(name = "__v")
        val v: Int,
        @Json(name = "verified")
        val verified: Boolean,
        @Json(name = "walletCash")
        val walletCash: Int

)
{
       /* val fullName: String
                get() = "${firstName ?: ""} ${lastName ?: ""}"*/
}