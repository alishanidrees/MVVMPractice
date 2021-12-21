package com.avancera.mvvmarchitectureapp.network

import com.avancera.bogocanada.constants.AppConstant
import com.avancera.mvvmarchitectureapp.models.request.RequestLogin
import com.avancera.mvvmarchitectureapp.models.response.LoginModel
import com.avancera.mvvmarchitectureapp.models.response.LoginResponseModel
import com.avancera.mvvmarchitectureapp.models.response.ResponseGeneral
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(AppConstant.ServerAPICalls.LOGIN_USER)
    suspend fun postCustomerLogin(@Body request: RequestLogin): Response<ResponseGeneral<LoginResponseModel>>


}