package com.firatveral.cakelist.data.model

import com.google.gson.annotations.SerializedName

data class Cake(@field:SerializedName("title") var title: String,
                 @field:SerializedName("desc") var desc: String,
                 @field:SerializedName("image") var image: String)
