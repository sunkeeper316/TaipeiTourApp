package com.sun.taipeitourapp.model.repository

import android.util.Log
import com.sun.taipeitourapp.api.AppClientManager
import com.sun.taipeitourapp.api.TaipeiTourService
import com.sun.taipeitourapp.model.AttractionListData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class AttractionListDataRepository {
    private val client =  AppClientManager.client
    fun getAttractionList(categoryIds: String?, nlat: Double?, elong: Double?, page: Int?, callback: (Throwable?, Response<AttractionListData>?) -> Unit) {
        val taipeiTourService = client.create(TaipeiTourService::class.java)
        taipeiTourService.getAttractionList(categoryIds, nlat, elong , page).enqueue(object : Callback<AttractionListData> {
            override fun onResponse(call: Call<AttractionListData>, response: Response<AttractionListData>) {
                Log.e("onResponse" , "onResponse ${response.body()?.data?.size}")
                callback(null,response)
            }
            override fun onFailure(call: Call<AttractionListData>, t: Throwable) {
                callback(t,null)
            }
        })
    }
}

//@Query("categoryIds") query: String,
//@Query("nlat") nlat: Double,
//@Query("elong") elong: Double,
//@Query("page")