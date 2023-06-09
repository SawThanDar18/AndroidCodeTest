package com.sawthandar.androidcodetest.api.request

import com.google.gson.annotations.SerializedName

data class LogInRequest(
    @SerializedName("CompanyId")
    var companyId: String,

    @SerializedName("UserId")
    var userId: String,

    @SerializedName("Password")
    var password: String
)