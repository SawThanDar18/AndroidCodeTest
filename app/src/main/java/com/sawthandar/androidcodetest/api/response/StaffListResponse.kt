package com.sawthandar.androidcodetest.api.response

import com.google.gson.annotations.SerializedName

data class StaffListResponse(
    @SerializedName("data")
    var data: Datas,

    @SerializedName("Error")
    var error: Boolean,

    @SerializedName("ErrorMsg")
    var errorMsg: String
)

data class Datas(
    @SerializedName("Items")
    var employees: List<Employees>
)

data class Employees(
    @SerializedName("Name")
    var name: String,

    @SerializedName("Value")
    var value: String

)