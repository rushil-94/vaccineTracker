package com.rushil.navigationexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rushil.navigationexample.R
import com.rushil.navigationexample.data.FindCityByPin
import com.rushil.navigationexample.data.Session
import com.rushil.navigationexample.databinding.ItemCityBinding

class CityFindByPinRVAdapter() :
    RecyclerView.Adapter<CityFindByPinRVAdapter.Holder>() {
    var findCityByPin: FindCityByPin? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class Holder private constructor(val itemCityBinding: ItemCityBinding) :
        RecyclerView.ViewHolder(itemCityBinding.root) {

        companion object {
            @JvmStatic
            fun getHolder(parent: ViewGroup): Holder {
                val itemCityBinding = DataBindingUtil.inflate<ItemCityBinding>(
                    LayoutInflater.from(parent.context),
                    R.layout.item_city, parent, false
                )
                return Holder(itemCityBinding = itemCityBinding)
            }
        }

        fun setValue(session: Session) {

            itemCityBinding.findCityByPin = session

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {

        return Holder.getHolder(parent)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        findCityByPin?.sessions?.let {
            holder.setValue(it[position])
        }


    }

    override fun getItemCount(): Int {
        return findCityByPin?.sessions?.size ?: 0
    }
}