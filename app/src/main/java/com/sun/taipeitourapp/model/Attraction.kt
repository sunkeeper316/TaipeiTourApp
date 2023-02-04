package com.sun.taipeitourapp.model

import com.google.gson.annotations.SerializedName

class Attraction {
    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("introduction")
    var introduction: String? = null
    @SerializedName("address")
    var address: String? = null
    @SerializedName("modified")
    var modified: String? = null
    @SerializedName("url")
    var url: String? = null
}