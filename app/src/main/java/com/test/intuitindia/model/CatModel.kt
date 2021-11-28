package com.test.intuitindia.model

import com.google.gson.annotations.SerializedName

data class CatModel(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String
)
