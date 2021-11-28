package com.test.intuitindia.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.intuitindia.model.CatModel
import com.test.intuitindia.repo.CatListService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CatListingViewModel(val catListService: CatListService) : BaseViewModel() {

    private val TAG = "CatListingViewModel"

    val dataListLiveData = MutableLiveData<List<CatModel>>()

    fun fetchData() {
        catListService.getCatList(100, 0)
            .doOnSubscribe {
                compositeDisposable.add(it)
            }
            .doFinally {

            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ list -> handleResponse(list) }, { e -> handleError(e) })
    }

    private fun handleError(e: Throwable? = null) {
        Log.e(TAG, e?.message, e)
    }

    private fun handleResponse(list: List<CatModel>?) {
        if (list.isNullOrEmpty()) {
            handleError()
        } else {
            dataListLiveData.value = list
        }
    }


    class CatListingViewModelFactory @Inject constructor(val catListService: CatListService) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CatListingViewModel(catListService) as T
        }
    }


}