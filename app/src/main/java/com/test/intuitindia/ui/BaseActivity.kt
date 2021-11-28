package com.test.intuitindia.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.test.intuitindia.viewmodel.BaseViewModel
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector

abstract class BaseActivity<D : ViewDataBinding, V : BaseViewModel?> : AppCompatActivity() {

    companion object {
        const val NO_BINDING_VAR = -1
    }

    private lateinit var mDataBinding: D
    var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mDataBinding.lifecycleOwner = this
        mViewModel = getViewModel()
        val bindingVariable = getBindingVariable()
        mViewModel?.let { vm ->
            if (bindingVariable > 0) {
                mDataBinding.setVariable(bindingVariable, vm)
            }
            lifecycle.addObserver(vm)
        }
        mDataBinding.executePendingBindings()
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V?

    abstract fun getBindingVariable(): Int

}