package com.rushil.navigationexample.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rushil.navigationexample.data.ApiService
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.repostories.NetWorkRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LoginViewModelFactory @Inject constructor(
    private val netWorkRepository: NetWorkRepository,
    private val application: Application
) :
    ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(netWorkRepository, application = application) as T
    }
}