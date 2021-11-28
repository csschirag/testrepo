package com.test.intuitindia.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.test.intuitindia.BR
import com.test.intuitindia.R
import com.test.intuitindia.databinding.CatListFragmentBinding
import com.test.intuitindia.viewmodel.CatListingViewModel
import com.test.intuitindia.viewmodel.CatListingViewModel.CatListingViewModelFactory
import javax.inject.Inject

class CatListFragment : BaseFragment<CatListFragmentBinding, CatListingViewModel>() {

    companion object {
        const val TAG = "CatListFragment"
        fun getInstance(): CatListFragment {
            return CatListFragment()
        }
    }

    @Inject
    lateinit var catListingViewModelFactory: CatListingViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDataBinding.catListView.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        mViewModel?.fetchData()
    }


    override fun getLayoutId(): Int {
        return R.layout.cat_list_fragment
    }

    override fun getViewModel(): CatListingViewModel {
        return ViewModelProvider(this, catListingViewModelFactory)[CatListingViewModel::class.java]
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }
}