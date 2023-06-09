package com.sawthandar.androidcodetest.api.response

import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("data")
    var data: Data,

    @SerializedName("Error")
    var error: Boolean,

    @SerializedName("ErrorMsg")
    var errorMsg: String
)

data class Data(
    @SerializedName("CompanyGUID")
    var companyGUID: String,

    @SerializedName("UserGUID")
    var userGUID: String,

    @SerializedName("isSuperUser")
    var isSuperUser: Boolean,

    @SerializedName("KeyId")
    var keyId: String,

    @SerializedName("success")
    var success: Boolean
)