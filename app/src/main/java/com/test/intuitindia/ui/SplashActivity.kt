package com.test.intuitindia.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.test.intuitindia.R
import com.test.intuitindia.databinding.SplashActivityBinding
import com.test.intuitindia.viewmodel.BaseViewModel

class SplashActivity : BaseActivity<SplashActivityBinding, BaseViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
                navigateToListingPage()
        }, 2000L)
    }

    private fun navigateToListingPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun getLayoutId(): Int {
        return R.layout.splash_activity
    }

    override fun getViewModel(): BaseViewModel? {
        return null;
    }

    override fun getBindingVariable(): Int {
        return NO_BINDING_VAR
    }
}