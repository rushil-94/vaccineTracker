package com.rushil.navigationexample.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.rushil.navigationexample.R
import com.rushil.navigationexample.adapters.CityFindByPinRVAdapter
import com.rushil.navigationexample.data.FindCityByPin
import com.rushil.navigationexample.databinding.FragmentFindCityListByPincodeBinding
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.viewmodels.MainViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [FindCityListByPinCodeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FindCityListByPinCodeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters


    private lateinit var fragmentFindCityListByPincodeBinding: FragmentFindCityListByPincodeBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var cityFindByPinRVAdapter: CityFindByPinRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentFindCityListByPincodeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_find_city_list_by_pincode,
            container,
            false
        )

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return fragmentFindCityListByPincodeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentFindCityListByPincodeBinding.btnNext.apply {
            setOnClickListener(this@FindCityListByPinCodeFragment)
        }

        fragmentFindCityListByPincodeBinding.fabFilter.apply {
            setOnClickListener(this@FindCityListByPinCodeFragment)
        }

        cityFindByPinRVAdapter = CityFindByPinRVAdapter()
        fragmentFindCityListByPincodeBinding.rvCityListFindByPinCode.adapter =
            cityFindByPinRVAdapter

        mainViewModel.cityListFindByPin.observe(viewLifecycleOwner) {
            Log.e("TAG", it.toString())
            cityFindByPinRVAdapter.findCityByPin = it
        }

        mainViewModel.progressBar.observe(viewLifecycleOwner) {
            fragmentFindCityListByPincodeBinding.progressCircular.visibility = if (it) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FindCityListByPinCodeFragment()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fabFilter -> {
                val navController = v.findNavController()

                navController.navigate(
                    FindCityListByPinCodeFragmentDirections.actionFindCityListByPinCodeFragmentToFilterDialogFragment(
                        0,
                        0
                    )
                )
            }

            R.id.btnNext -> {
                if (fragmentFindCityListByPincodeBinding.etPinCode.editableText.isNotEmpty()) {
                    mainViewModel.getCityList(
                        fragmentFindCityListByPincodeBinding.etPinCode.editableText.toString(),
                        Utility.getCurrentDate()
                    )
                } else {
                    Utility.showToast(requireContext(), "Enter PinCode")
                }

            }
        }

    }

}