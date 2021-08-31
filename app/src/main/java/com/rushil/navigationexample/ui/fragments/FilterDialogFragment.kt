package com.rushil.navigationexample.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rushil.navigationexample.R
import com.rushil.navigationexample.adapters.FilterRVAdapter
import com.rushil.navigationexample.databinding.DialogFragmentFilterListBinding
import com.rushil.navigationexample.viewmodels.MainViewModel

class FilterDialogFragment : BottomSheetDialogFragment(), View.OnClickListener {

    private lateinit var dialogFilterDialogFragment: DialogFragmentFilterListBinding
    private lateinit var filterRVAdapter: FilterRVAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialogFilterDialogFragment =
            DialogFragmentFilterListBinding.inflate(layoutInflater)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        filterRVAdapter = FilterRVAdapter(mainViewModel.filterList, mainViewModel)
        dialogFilterDialogFragment.rvFilterList.adapter = filterRVAdapter
        dialogFilterDialogFragment.textTitle.text = "Filter"
        dialog.setContentView(dialogFilterDialogFragment.root)

        dialogFilterDialogFragment.btnOk.setOnClickListener(this)


        return dialog
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FilterDialogFragment()
    }

    override fun onClick(v: View?) {
        mainViewModel.getCityListBasedOnFilter()
        dismiss()
    }
}