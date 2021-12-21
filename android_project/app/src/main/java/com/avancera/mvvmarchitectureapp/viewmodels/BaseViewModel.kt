package com.avancera.mvvmarchitectureapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avancera.bogocanada.constants.AppConstant
import com.avancera.mvvmarchitectureapp.ApplicationClass
import com.avancera.mvvmarchitectureapp.models.helper.NavigationModel
import com.avancera.mvvmarchitectureapp.models.response.ResponseGeneral
import com.avancera.mvvmarchitectureapp.utils.DisplayNotification
import com.avancera.mvvmarchitectureapp.utils.Event
import com.google.gson.Gson
import kotlinx.coroutines.*
import okhttp3.ResponseBody
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class BaseViewModel : ViewModel() {

    private val job = SupervisorJob()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

    protected val coroutineScope = CoroutineScope(job + Dispatchers.IO + coroutineExceptionHandler)


    protected fun handleServerError(errorBody: ResponseBody?) {

        errorBody?.apply {
            val error = Gson().fromJson(
                this.string(),
                ResponseGeneral::class.java //CHANGE TO SPECIFIC ERROR RESPONSE
            )


            CoroutineScope(Dispatchers.Main).launch {
                if (error.errors?.isNotEmpty() == true) {
                    DisplayNotification.showToast(ApplicationClass.application,error.message?.joinToString("\n") ?: "",AppConstant.TOAST_TYPES.ERROR)
                  //  callMessageNotification(error.errors?.joinToString("\n") ?: "")
                } else {
                    DisplayNotification.showToast(ApplicationClass.application,error.message?.joinToString("\n") ?: "",AppConstant.TOAST_TYPES.ERROR)
                //    callMessageNotification(error.message ?: "")

                }
            }
        }
    }

    protected fun showErrorMessage(throwable: Throwable) {

        throwable.printStackTrace()

        when (throwable) {

            is SocketTimeoutException -> {
                DisplayNotification.showToast(ApplicationClass.application, "Internet",AppConstant.TOAST_TYPES.ERROR)

//                callMessageNotification(
//                    ApplicationClass.languageJson?.messages?.errorMessages?.internet ?: ""
//                )
            }

            is UnknownHostException -> {

                DisplayNotification.showToast(ApplicationClass.application, "Internet",AppConstant.TOAST_TYPES.ERROR)

             /*   callMessageNotification(
                    ApplicationClass.languageJson?.messages?.errorMessages?.internet ?: ""
                )*/

            }

            else -> {

                DisplayNotification.showToast(ApplicationClass.application, "Internet",AppConstant.TOAST_TYPES.ERROR)

            /*    callMessageNotification(
                    ApplicationClass.languageJson?.messages?.errorMessages?.internal ?: ""
                )*/

            }
        }
    }


    val navigateTo: LiveData<Event<NavigationModel>>
        get() = _navigateTo


    private val _navigateBack = MutableLiveData<Event<Boolean>>()

    val navigateBack: LiveData<Event<Boolean>>
        get() = _navigateBack


    fun setNavigateBack(value: Boolean = true) {
        _navigateBack.value = Event(value)
    }

    private val _navigateTo = MutableLiveData<Event<NavigationModel>>()


    fun setNavigateTo(model: NavigationModel) {
        _navigateTo.value = Event(model)
    }


   /* fun callMessageNotification(
        msg: String,
        style: DisplayNotification.STYLE = DisplayNotification.STYLE.FAILURE
    ) {
        try {
            CoroutineScope(Dispatchers.Main).launch {
                handleServerError
                setNotificationMessage(
                    NotificationMessage(message = msg, style = style)
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }

    fun setNotificationMessage(message: NotificationMessage) {
        _notificationMessage.value = message
    }

*/

}