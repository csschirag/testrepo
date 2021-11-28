package com.test.intuitindia.bindingadapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.intuitindia.adapter.CatRecyclerViewAdapter
import com.test.intuitindia.model.CatModel

@BindingAdapter("imageUrl", "placeHolder")
fun loadImage(imageView: AppCompatImageView, imageUrl: String?, placeHolder: Int) {
    imageUrl?.let {
        Glide.with(imageView).load(it)
            .error(placeHolder)
            .into(imageView)
    } ?: run {
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, placeHolder))
    }
}


@BindingAdapter("dataList")
fun populateList(recyclerView: RecyclerView, dataList: List<CatModel>?) {
    if (dataList.isNullOrEmpty()) {
        return
    }
    val layoutManager = LinearLayoutManager(recyclerView.context)
    recyclerView.layoutManager = layoutManager
    val adapter = CatRecyclerViewAdapter(recyclerView.context, dataList)
    recyclerView.adapter = adapter
//    adapter.notifyDataSetChanged()
}