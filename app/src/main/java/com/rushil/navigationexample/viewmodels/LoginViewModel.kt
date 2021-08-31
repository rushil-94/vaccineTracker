package com.rushil.navigationexample.viewmodels

import android.app.Application
import android.util.Base64
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rushil.navigationexample.adapters.FilterRVAdapter
import com.rushil.navigationexample.data.*
import com.rushil.navigationexample.data.db.dao.FindCityByPinDao
import com.rushil.navigationexample.misc.RandomString
import com.rushil.navigationexample.misc.encodeStringSHA256
import com.rushil.navigationexample.repostories.NetWorkRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(
    private val repository: NetWorkRepository,
    application: Application
) :
    AndroidViewModel(application) {
    private val _progressBar: MutableLiveData<Boolean> = MutableLiveData()
    private val _isOTPGenerate: MutableLiveData<Boolean> = MutableLiveData()
    private val _isLogin: MutableLiveData<Boolean> = MutableLiveData()
    val progressBar: LiveData<Boolean> = _progressBar
    val isOTPGenerate: LiveData<Boolean> = _isOTPGenerate
    val isLogin: LiveData<Boolean> = _isLogin


    private var generateOTP: GenerateOTP? = null
    private var confirmOTP: ConfirmOTP? = null

    fun generateOTP(phoneNumber: String) {
        _progressBar.postValue(true)
        viewModelScope.launch {
            try {
                generateOTP = repository.generateOTP(GenerateOTPRequestBody(phoneNumber))?.apply {
                    Log.e("TAG", txnId)
                    _isOTPGenerate.value = txnId.isNotEmpty()
                    _progressBar.postValue(false)
                }

            } catch (exception: Exception) {
                exception.printStackTrace()
                _isOTPGenerate.value = false
                _progressBar.postValue(false)
            }

        }
    }

    fun login(otp: String) {
        _progressBar.postValue(true)
        viewModelScope.launch {
            try {

                confirmOTP = repository.login(
                    ConfirmOTPRequestBody(otp.encodeStringSHA256(), generateOTP?.txnId!!)
                )?.apply {
                    Log.e("TAG", token)
                    _isLogin.value = token.isNotEmpty()
                    _progressBar.postValue(false)
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
                _isLogin.value = false
                _progressBar.postValue(false)
            }


        }
    }


}