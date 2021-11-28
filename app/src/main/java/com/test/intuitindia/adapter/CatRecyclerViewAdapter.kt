package com.test.intuitindia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.intuitindia.R
import com.test.intuitindia.adapter.CatRecyclerViewAdapter.CatItemViewHolder
import com.test.intuitindia.databinding.CatRowItemBinding
import com.test.intuitindia.model.CatModel
import com.test.intuitindia.viewmodel.CatCardViewModel

class CatRecyclerViewAdapter(private val context: Context, private val dataList: List<CatModel>) :
    RecyclerView.Adapter<CatItemViewHolder>() {


    class CatItemViewHolder(val catRowItemBinding: CatRowItemBinding) :
        RecyclerView.ViewHolder(catRowItemBinding.root) {

        fun bindData(catModel: CatModel) {
            catRowItemBinding.viewModel?.updateData(catModel)
                ?: kotlin.run { catRowItemBinding.viewModel = CatCardViewModel(catModel) }
            catRowItemBinding.viewModel = CatCardViewModel(catModel)
            catRowItemBinding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatItemViewHolder {
        return CatItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(
                    context
                ), R.layout.cat_row_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CatItemViewHolder, position: Int) {
        holder.bindData(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}