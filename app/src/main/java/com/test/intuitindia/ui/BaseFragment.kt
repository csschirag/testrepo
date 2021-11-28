package com.test.intuitindia.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.test.intuitindia.viewmodel.BaseViewModel
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment <D : ViewDataBinding, V : BaseViewModel?> : Fragment() {

    companion object {
        const val NO_BINDING_VAR = -1
    }

    lateinit var mDataBinding: D
    var mViewModel: V? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performDataBinding(inflater, container)
        return mDataBinding.root
    }

    private fun performDataBinding(inflater: LayoutInflater,
                                   container: ViewGroup?) {
        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
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
        AndroidSupportInjection.inject(this)
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V?

    abstract fun getBindingVariable(): Int



}