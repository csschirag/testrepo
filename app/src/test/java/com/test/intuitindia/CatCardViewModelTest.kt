package com.test.intuitindia

import com.test.intuitindia.model.CatModel
import com.test.intuitindia.viewmodel.CatCardViewModel
import org.junit.Assert
import org.junit.Test

class CatCardViewModelTest {

    @Test
    fun isShowCatImage() {
        val catCardViewModel = CatCardViewModel(CatModel("2123","sadasdda"))
        Assert.assertTrue(catCardViewModel.showCatImage())
    }

    @Test
    fun isNotShowCatImage() {
        val catCardViewModel = CatCardViewModel(CatModel("2123",""))
        Assert.assertFalse(catCardViewModel.showCatImage())
    }

    @Test
    fun isDataUpdated() {
        val catCardViewModel = CatCardViewModel(CatModel("2123",""))
        catCardViewModel.updateData(CatModel("2224",""))
        Assert.assertEquals(catCardViewModel.getCatID(), "2224")
    }
}