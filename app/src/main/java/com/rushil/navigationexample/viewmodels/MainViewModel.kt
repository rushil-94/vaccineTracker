package com.rushil.navigationexample.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.rushil.navigationexample.adapters.FilterRVAdapter
import com.rushil.navigationexample.data.FindCityByPin
import com.rushil.navigationexample.data.ItemFilter
import com.rushil.navigationexample.data.db.dao.FindCityByPinDao
import com.rushil.navigationexample.repostories.NetWorkRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: NetWorkRepository,
    application: Application
) :
    AndroidViewModel(application), FilterRVAdapter.OnSetItemClickListener {
    private val _cityListFindByPin: MutableLiveData<FindCityByPin> =
        MutableLiveData<FindCityByPin>()
    private val _progressBar: MutableLiveData<Boolean> = MutableLiveData()

    val cityListFindByPin: LiveData<FindCityByPin> = _cityListFindByPin
    val progressBar: LiveData<Boolean> = _progressBar
    val filterList = listOf<ItemFilter>(
        ItemFilter("COVAXIN", false),
        ItemFilter("COVIDSHIELD", false),
        ItemFilter("FREE", false),
        ItemFilter("PAID", false)
    )


    fun getCityList(pincode: String, date: String) {
        _progressBar.value = true
        viewModelScope.launch {
            try {
                val res = repository.findCityByPin(pincode, date)
//                findCityByPinDao.insert(res)
                _cityListFindByPin.postValue(res)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _progressBar.value = false
            }

        }

    }

    fun getVaccinateCertificate(beneficiary_reference_id: String) {
        viewModelScope.launch {
            try {
                val res = repository.getVaccinateCertificate(beneficiary_reference_id)

            } catch (ex: Exception) {
                ex.printStackTrace()

            }
        }
    }

    fun getCityListBasedOnFilter() {
        viewModelScope.launch {
            Log.e("TAG", filterList.toString())
        }
    }

    override fun onItemClick(position: Int) {
        filterList[position].isSelected = !filterList[position].isSelected
    }


}