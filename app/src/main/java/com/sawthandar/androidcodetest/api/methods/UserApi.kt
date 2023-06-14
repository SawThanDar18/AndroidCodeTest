package com.sawthandar.androidcodetest.api.methods

import com.sawthandar.androidcodetest.api.ApiClient
import com.sawthandar.androidcodetest.api.request.LogInRequest
import com.sawthandar.androidcodetest.api.response.LogInResponse
import com.sawthandar.androidcodetest.api.response.StaffListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @POST("Individual/login")
    suspend fun loginUser(
        @Body logInRequest: LogInRequest
    ): Response<LogInResponse>

    @GET("Staff")
    suspend fun getStaffList(@Header("AccessToken") accessToken: String?): Response<StaffListResponse>

    companion object {
        fun getApi(): UserApi {
            return ApiClient.client().create(UserApi::class.java)
        }
    }
}