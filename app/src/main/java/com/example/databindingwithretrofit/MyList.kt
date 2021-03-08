package com.example.databindingwithretrofit

import com.google.gson.annotations.SerializedName

class MyList {
    @SerializedName("id")
    var id = ""

    @JvmField
    @SerializedName("name")
    var artistname = ""

    @JvmField
    @SerializedName("imageurl")
    var artistimage = ""

    @JvmField
    @SerializedName("moviename")
    var moviename = ""
}