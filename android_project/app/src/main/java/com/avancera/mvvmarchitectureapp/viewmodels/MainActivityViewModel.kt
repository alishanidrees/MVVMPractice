package com.avancera.mvvmarchitectureapp.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.avancera.mvvmarchitectureapp.R
import com.avancera.mvvmarchitectureapp.models.helper.NavigationModel
import com.avancera.mvvmarchitectureapp.models.request.RequestLogin
import com.avancera.mvvmarchitectureapp.models.response.LoginModel
import com.avancera.mvvmarchitectureapp.models.response.LoginResponseModel
import com.avancera.mvvmarchitectureapp.network.ApiRepository
import com.avancera.mvvmarchitectureapp.utils.Enums
import com.avancera.mvvmarchitectureapp.utils.SharedPrefDB
import com.avancera.mvvmarchitectureapp.utils.onError
import com.avancera.mvvmarchitectureapp.utils.onSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

@SuppressLint("NullSafeMutableLiveData")
internal class MainActivityViewModel : BaseViewModel(){


    private val mTinyDb by lazy { SharedPrefDB.instance }

    fun callServerForLoginCustomer(requestLogin: RequestLogin) {

        coroutineScope.launch {

          //  setDisableClick(true)

            try {
                val data = ApiRepository.callPostCustomerLogin(requestLogin)

                data.onSuccess {
                    if (it.isSuccessful) {

                        withContext(Dispatchers.Main) {
                            _responseCustomerDetails.value = it.body()?.data

                            Log.i("DataCall",""+_responseCustomerDetails.value!!.token)
                            mTinyDb.putString(
                                Enums.TinyDBKeys.TOKEN_USER.key,
                                _responseCustomerDetails.value!!.token ?: ""
                            )
                        //    loading = false
                            setNavigateTo(
                                NavigationModel(
                                    id = R.id.action_homeFragment_to_testFragment
                                )
                            )

                            Log.i("ShredToken",mTinyDb.getString(Enums.TinyDBKeys.TOKEN_USER.key))

                        }


                    } else {

                        handleServerError(it.errorBody())

                    }

                }.onError {

                    showErrorMessage(it.exception)

                }
            } catch (e: Exception) {
                showErrorMessage(e)
            } finally {
             /*   setHandleAnimation(true)
                setDisableClick(false)*/
            }

        }

    }

    private val _responseCustomerDetails = MutableLiveData<LoginResponseModel>()


}