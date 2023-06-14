package com.sawthandar.androidcodetest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sawthandar.androidcodetest.api.repository.UserRepository
import com.sawthandar.androidcodetest.api.request.LogInRequest
import com.sawthandar.androidcodetest.api.response.BaseResponse
import com.sawthandar.androidcodetest.api.response.LogInResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class LogInViewModel(application: Application): AndroidViewModel(application) {

    val userRepository = UserRepository()
    val logInResult: MutableLiveData<BaseResponse<LogInResponse>> = MutableLiveData()

    fun logInUser(companyId: String, userId: String, password: String) {
        logInResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {

                val loginRequest = LogInRequest(
                    companyId, userId, password
                )
                val response = userRepository.logInUser(
                    loginRequest
                )

                if (response.body()?.error == false) {
                    logInResult.value = BaseResponse.Success(response.body())
                } else {
                    logInResult.value = BaseResponse.Error(response.message())
                }
            } catch (exception: Exception) {
                logInResult.value = BaseResponse.Error(exception.message.toString())
            }
        }
    }
}