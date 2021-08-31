package com.rushil.navigationexample.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rushil.navigationexample.data.FindCityByPin
import com.rushil.navigationexample.data.ItemFilter

@Dao
interface FindCityByPinDao {

//    @Insert
//    fun insert(findCityByPin: FindCityByPin)
//
//    @Query("select * from FindCityByPin")
//    fun getCity() : FindCityByPin

//    @Query("select * from FindCityByPin where fee in : filter")
//    fun getCityBasedOnFilter(filter:List<ItemFilter>):FindCityByPin
}