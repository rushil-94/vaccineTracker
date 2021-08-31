package com.rushil.navigationexample.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FindCityByPin(@Expose @SerializedName("sessions") val sessions: List<Session>)

//data class Session(@Expose @SerializedName("sessions") val sessions: List<Response>)

data class Session(
    @Expose @SerializedName("center_id") val center_id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("address") val address: String,
    @Expose @SerializedName("state_name") val state_name: String,
    @Expose @SerializedName("fee_type") val fee_type: String,
    @Expose @SerializedName("fee") val fee: String,
    @Expose @SerializedName("vaccine") val vaccine: String,
    @Expose @SerializedName("date") val date: String,
    @Expose @SerializedName("session_id") val session_id: String
)

data class ItemFilter(val title: String, var isSelected: Boolean)

data class GenerateOTP(@Expose @SerializedName("txnId") val txnId: String)
data class ConfirmOTP(@Expose @SerializedName("token") val token: String)

data class GenerateOTPRequestBody(val mobile: String)
data class ConfirmOTPRequestBody(val otp: String, val txnId: String)