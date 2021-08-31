package com.rushil.navigationexample.repostories

import com.rushil.navigationexample.data.ApiService
import com.rushil.navigationexample.data.ConfirmOTPRequestBody
import com.rushil.navigationexample.data.GenerateOTPRequestBody

class NetWorkRepository(private val apiService: ApiService) {

    suspend fun findCityByPin(pincode: String, date: String) =
        apiService.findCityByPin(pincode, date)

    suspend fun generateOTP(generateOTPRequestBody: GenerateOTPRequestBody) =
        apiService.generateOTP(generateOTPRequestBody)

    suspend fun login(confirmOTPRequestBody: ConfirmOTPRequestBody) =
        apiService.login(confirmOTPRequestBody)

    suspend fun getVaccinateCertificate(beneficiary_reference_id: String) =
        apiService.getVaccinateCertificate(beneficiary_reference_id)

}