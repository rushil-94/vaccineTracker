package com.rushil.navigationexample.ui.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.rushil.navigationexample.R
import com.rushil.navigationexample.databinding.ActivityLoginBinding
import com.rushil.navigationexample.databinding.FragmentLoginBinding
import com.rushil.navigationexample.misc.CustomApplication
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.viewmodels.LoginViewModel
import com.rushil.navigationexample.viewmodels.LoginViewModelFactory
import com.rushil.navigationexample.viewmodels.MainViewModel
import com.rushil.navigationexample.viewmodels.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var activityLoginBinding: ActivityLoginBinding

    private lateinit var loginViewModel: LoginViewModel

//   @Inject
//    lateinit var loginViewModelFactory: LoginViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLoginBinding =
            DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        loginViewModel = ViewModelProvider(this@LoginActivity).get(LoginViewModel::class.java)

        Utility.log("$loginViewModel  ")
    }


}