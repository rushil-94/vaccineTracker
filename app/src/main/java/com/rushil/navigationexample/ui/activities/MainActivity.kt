package com.rushil.navigationexample.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rushil.navigationexample.R
import com.rushil.navigationexample.databinding.ActivityMainBinding
import com.rushil.navigationexample.misc.CustomApplication
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.viewmodels.MainViewModel
import com.rushil.navigationexample.viewmodels.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    private lateinit var activityMainBinding: ActivityMainBinding

//    @Inject
//    lateinit var mainViewModelFactory: MainViewModelFactory
//
//    @Inject
//    lateinit var _mainViewModelFactory: MainViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        init()

    }


    private fun init() {

        mainViewModel = ViewModelProvider(this@MainActivity).get(MainViewModel::class.java)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        activityMainBinding.bnv.setupWithNavController(navController)

//        Utility.log("${mainViewModelFactory}  $_mainViewModelFactory")
    }

}