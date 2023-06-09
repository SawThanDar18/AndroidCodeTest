package com.sawthandar.androidcodetest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sawthandar.androidcodetest.api.repository.UserRepository
import com.sawthandar.androidcodetest.api.response.BaseResponse
import com.sawthandar.androidcodetest.api.response.StaffListResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class StaffListViewModel(application: Application): AndroidViewModel(application) {

    val userRepository = UserRepository()
    val staffListResult:MutableLiveData<BaseResponse<StaffListResponse>> = MutableLiveData()

    fun getStaffList(accessToken: String) {
        staffListResult.value = BaseResponse.Loading()
        viewModelScope.launch {
            try {
                val response = userRepository.getStaffList(accessToken = accessToken)
                if (response?.body()?.error == false) {
                    staffListResult.value = BaseResponse.Success(response.body())
                } else {
                    staffListResult.value = BaseResponse.Error(response?.message())
                }
            } catch (exception: Exception) {
                staffListResult.value = BaseResponse.Error(exception.message)
            }
        }
    }
}