package com.rushil.navigationexample.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rushil.navigationexample.data.ApiService
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.repostories.NetWorkRepository

class MainViewModelFactory(private val application: Application) :
    ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(
            NetWorkRepository(
                Utility.getRetrofit().create(ApiService::class.java)
            ), application = application
        ) as T
    }
}