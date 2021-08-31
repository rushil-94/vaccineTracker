package com.rushil.navigationexample.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.RecyclerView
import com.rushil.navigationexample.data.ItemFilter
import com.rushil.navigationexample.databinding.ItemFilterBinding

class FilterRVAdapter(
    private val filterList: List<ItemFilter>,
    private var setItemClickListener: OnSetItemClickListener?
) :
    RecyclerView.Adapter<FilterRVAdapter.Holder>() {

    class Holder private constructor(
        private val itemFilterBinding: ItemFilterBinding,
        private val setItemClickListener: OnSetItemClickListener?
    ) :
        RecyclerView.ViewHolder(itemFilterBinding.root), CompoundButton.OnCheckedChangeListener {

        companion object {
            fun getHolder(
                parent: ViewGroup,
                setItemClickListener: OnSetItemClickListener?
            ): Holder {
                val itemFilterBinding = ItemFilterBinding.inflate(
                    LayoutInflater.from(parent.context)
                )
                return Holder(
                    itemFilterBinding,
                    setItemClickListener = setItemClickListener
                )
            }
        }

        fun setValue(value: ItemFilter) {
            itemFilterBinding.text = value.title
            itemFilterBinding.cbFilterItem.isChecked = value.isSelected
            itemFilterBinding.cbFilterItem.setOnCheckedChangeListener(this)
        }

        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            setItemClickListener?.onItemClick(adapterPosition)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder.getHolder(parent, setItemClickListener)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.setValue(filterList[position])

    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    interface OnSetItemClickListener {
        fun onItemClick(position: Int)
    }
}