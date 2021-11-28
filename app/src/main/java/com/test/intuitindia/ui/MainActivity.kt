package com.test.intuitindia.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.test.intuitindia.BR
import com.test.intuitindia.R
import com.test.intuitindia.databinding.ActivityMainBinding
import com.test.intuitindia.viewmodel.MainActivityViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, CatListFragment.getInstance(), CatListFragment.TAG)
            .commit()
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainActivityViewModel {
        return ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

}