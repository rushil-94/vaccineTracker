package com.rushil.navigationexample.data.db.room

import android.content.Context
import android.database.DatabaseUtils
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rushil.navigationexample.data.FindCityByPin
import com.rushil.navigationexample.data.db.dao.FindCityByPinDao

//@Database(entities = [FindCityByPin::class],version = 1,exportSchema = false)
//abstract class CustomRoom : RoomDatabase()  {
//   abstract fun getDao():FindCityByPinDao
//
//    companion object{
//       private lateinit var  INSTANCE : CustomRoom
//
//        fun getInstance(context: Context):CustomRoom{
//            if(INSTANCE==null){
//                INSTANCE = Room.databaseBuilder(context,CustomRoom::class.java,"cowin")
//                    .fallbackToDestructiveMigration()
//                    .build()
//            }
//            return INSTANCE
//        }
//    }
//}