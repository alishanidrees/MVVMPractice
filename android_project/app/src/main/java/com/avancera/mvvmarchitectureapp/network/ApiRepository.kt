package com.avancera.mvvmarchitectureapp.network

import com.avancera.mvvmarchitectureapp.ApplicationClass
import com.avancera.mvvmarchitectureapp.models.request.RequestLogin
import com.avancera.mvvmarchitectureapp.models.response.LoginModel
import com.avancera.mvvmarchitectureapp.models.response.LoginResponseModel
import com.avancera.mvvmarchitectureapp.models.response.ResponseGeneral
import com.avancera.mvvmarchitectureapp.utils.Error
import com.avancera.mvvmarchitectureapp.utils.Result
import com.avancera.mvvmarchitectureapp.utils.Success
import retrofit2.Response

object ApiRepository {

    private var api: ApiService? = RemoteDataSource.apiInstance(ApplicationClass.application)

    suspend fun callPostCustomerLogin(request: RequestLogin): Result<Response<ResponseGeneral<LoginResponseModel>>> {


        return callApi {

        api!!.postCustomerLogin(request)

        } as Result<Response<ResponseGeneral<LoginResponseModel>>>


    }

    private suspend fun <T> callApi(api: suspend () -> Response<T>): Result<Any> {

        return try {
            Success(api.invoke())
        } catch (e: Exception) {
            Error(e)
        }
    }


}