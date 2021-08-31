package com.rushil.navigationexample.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.rushil.navigationexample.R
import com.rushil.navigationexample.databinding.FragmentDownloadVaccinateCertificateBinding
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.viewmodels.MainViewModel

class DownloadVaccinateCertificateFragment : Fragment(), View.OnClickListener {
    lateinit var mainViewModel: MainViewModel
    lateinit var fragmentDownloadVaccinateCertificateBinding: FragmentDownloadVaccinateCertificateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentDownloadVaccinateCertificateBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_download_vaccinate_certificate,
            container,
            false
        )
        return fragmentDownloadVaccinateCertificateBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        fragmentDownloadVaccinateCertificateBinding.btnDownload.setOnClickListener(this@DownloadVaccinateCertificateFragment)


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = DownloadVaccinateCertificateFragment()
    }

    override fun onClick(v: View?) {
        val value =
            fragmentDownloadVaccinateCertificateBinding.etBeneficiaryReferenceId.editableText.toString()
                .also {
                    if (it.isNotEmpty())
                        mainViewModel.getVaccinateCertificate(it)
                    else {
                        Utility.showToast(requireContext(), "Enter Beneficiary Reference Id")
                    }
                }


    }
}