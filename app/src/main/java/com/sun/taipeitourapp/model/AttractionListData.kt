package com.sun.taipeitourapp.model

import com.google.gson.annotations.SerializedName

class AttractionListData {
    @SerializedName("total")
    var total: Int? = 0
    @SerializedName("data")
    var data: MutableList<Attraction>? = null
}