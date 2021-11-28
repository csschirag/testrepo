package com.test.intuitindia.viewmodel

import androidx.databinding.ObservableField
import com.test.intuitindia.model.CatModel

class CatCardViewModel(var catModel: CatModel) : BaseViewModel() {

    val imageUrlObservable = ObservableField(catModel.url)

    fun getCatID(): String {
        return catModel.id
    }

    fun updateData(catModel: CatModel) {
        this.catModel = catModel
        imageUrlObservable.set(catModel.url)
    }

    fun showCatImage() : Boolean {
        return !catModel.url.isNullOrEmpty()
    }

}