package com.sawthandar.androidcodetest.api.repository

import com.sawthandar.androidcodetest.api.methods.UserApi
import com.sawthandar.androidcodetest.api.request.LogInRequest
import com.sawthandar.androidcodetest.api.response.LogInResponse
import com.sawthandar.androidcodetest.api.response.StaffListResponse
import retrofit2.Response

class UserRepository {
    suspend fun logInUser(logInRequest: LogInRequest): Response<LogInResponse> {
        return UserApi.getApi().loginUser(
            logInRequest = logInRequest
        )
    }

    suspend fun getStaffList(accessToken: String): Response<StaffListResponse> {
        return UserApi.getApi().getStaffList(
            accessToken = accessToken
        )
    }
}