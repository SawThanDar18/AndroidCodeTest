package com.sawthandar.androidcodetest.api.repository

import com.sawthandar.androidcodetest.api.methods.UserApi
import com.sawthandar.androidcodetest.api.response.LogInResponse
import com.sawthandar.androidcodetest.api.response.StaffListResponse
import retrofit2.Response

class UserRepository {
    suspend fun logInUser(companyId: String, userId: String, password: String): Response<LogInResponse>? {
        return UserApi.getApi()?.loginUser(
            companyId = companyId,
            userId = userId,
            password = password
        )
    }

    suspend fun getStaffList(accessToken: String): Response<StaffListResponse>? {
        return UserApi.getApi()?.getStaffList(
            accessToken = accessToken
        )
    }
}