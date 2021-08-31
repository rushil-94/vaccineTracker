package com.rushil.navigationexample.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rushil.navigationexample.R
import com.rushil.navigationexample.databinding.ActivityLoginBinding
import com.rushil.navigationexample.databinding.FragmentLoginBinding
import com.rushil.navigationexample.misc.CustomApplication
import com.rushil.navigationexample.viewmodels.LoginViewModel
import com.rushil.navigationexample.viewmodels.MainViewModel
import com.rushil.navigationexample.viewmodels.MainViewModelFactory

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var fragmentLoginBinding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return fragmentLoginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)
        fragmentLoginBinding.btnGenerateOTP.setOnClickListener(this)
        fragmentLoginBinding.btnLogin.setOnClickListener(this)

        loginViewModel.progressBar.observe(viewLifecycleOwner) {
            if (it) {
                fragmentLoginBinding.progressCircular.visibility = View.VISIBLE
            } else {
                fragmentLoginBinding.progressCircular.visibility = View.GONE
            }
        }

        loginViewModel.isOTPGenerate.observe(viewLifecycleOwner) {
            setViewVisibility(it)
        }

        loginViewModel.isLogin.observe(viewLifecycleOwner) {
            if (it) {
                val navController = findNavController()

                navController.navigate(LoginFragmentDirections.loginFragmentToMainActivity())
                navController.popBackStack()


            }
        }
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = LoginFragment()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnGenerateOTP -> {
                loginViewModel.generateOTP(fragmentLoginBinding.etMobileNumber.editableText.toString())
            }
            R.id.btnLogin -> {
                loginViewModel.login(fragmentLoginBinding.etOTPNumber.editableText.toString())
            }
        }
    }

    private fun setViewVisibility(isOTPGenerate: Boolean) {
        if (isOTPGenerate) {
            fragmentLoginBinding.btnGenerateOTP.visibility = View.GONE
            fragmentLoginBinding.etMobileNumber.visibility = View.GONE

            fragmentLoginBinding.btnLogin.visibility = View.VISIBLE
            fragmentLoginBinding.etOTPNumber.visibility = View.VISIBLE
        } else {
            fragmentLoginBinding.btnGenerateOTP.visibility = View.VISIBLE
            fragmentLoginBinding.etMobileNumber.visibility = View.VISIBLE

            fragmentLoginBinding.btnLogin.visibility = View.GONE
            fragmentLoginBinding.etOTPNumber.visibility = View.GONE
        }
    }
}