package com.avancera.mvvmarchitectureapp.network

import android.content.Context
import com.avancera.bogocanada.constants.AppConstant
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RemoteDataSource {

    private var apiService: ApiService? = null
   // var prefHelper:BasePreferenceHelper? = null

    fun apiInstance(context: Context): ApiService? {
       //  prefHelper = BasePreferenceHelper(context)

        if (apiService == null) {
            val logging = HttpLoggingInterceptor()

            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder()
            httpClient.callTimeout(1, TimeUnit.MINUTES)
            httpClient.connectTimeout(20, TimeUnit.SECONDS)
            httpClient.readTimeout(30, TimeUnit.SECONDS)
            httpClient.writeTimeout(30, TimeUnit.SECONDS)
            httpClient.addInterceptor(Interceptor { chain ->
                val original = chain.request()

                val requestBuilder: Request.Builder = original.newBuilder()

            /*    if (prefHelper != null && prefHelper!!.getUser() != null) {
                    val tokenValue = prefHelper!!.getUser()!!.token

                    requestBuilder.addHeader("Accept", "application/json")
                    requestBuilder.addHeader(
                        "Authorization", String.format("Bearer %s", tokenValue))
                }*/
                val request = requestBuilder.build()
                chain.proceed(request)
            })
            httpClient.addInterceptor(logging)
            val retrofit = Retrofit.Builder()
                .baseUrl(AppConstant.ServerAPICalls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService
    }
}