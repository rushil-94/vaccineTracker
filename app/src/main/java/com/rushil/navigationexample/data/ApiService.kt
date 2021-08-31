package com.rushil.navigationexample.data

import com.rushil.navigationexample.misc.Constants
import retrofit2.http.*

interface ApiService {
    @GET(Constants.FIND_BY_CITY_PIN_CODE)
    suspend fun findCityByPin(

        @Query("pincode") pincode: String,
        @Query("date") date: String
    ): FindCityByPin

    @POST(Constants.GENERATE_OTP)
    suspend fun generateOTP(@Body generateOTPRequestBody: GenerateOTPRequestBody): GenerateOTP

    @POST(Constants.CONFIRM_OTP)
    suspend fun login(@Body confirmOTPRequestBody: ConfirmOTPRequestBody): ConfirmOTP

    @GET(Constants.DOWNLOAD_VACCINATE_CERTIFICATE)
    suspend fun getVaccinateCertificate(@Query("beneficiary_reference_id") beneficiary_reference_id: String): String
}