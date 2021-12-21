package com.avancera.mvvmarchitectureapp.models.response

data class LoginModel(

    val `data`: Data,
    val message: List<Any>,
    val status: Boolean

){

    data class Data(
        val __v: Int,
        val _id: String,
        val active: Boolean,
        val activeSubscriptionId: String,
        val credits: Any,
        val customerId: String,
        val email: String,
        val fullName: String,
        val limitPerCategory: Int,
        val phoneNumber: String,
        val profileImage: String,
        val referalKey: String,
        val subscriptionRenewalDate: String,
        val subscriptionTimeLeft: String,
        val token: String,
        val trial: Boolean,
        val type: Int,
        val walletCash: Any,
        val verified: Boolean,
        val couponUsed: Int
    )
}