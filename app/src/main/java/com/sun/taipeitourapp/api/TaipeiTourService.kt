package com.sun.taipeitourapp.api

import com.sun.taipeitourapp.model.AttractionListData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TaipeiTourService {
    @Headers("Accept: application/json")
    @GET("Attractions/All")
    fun getAttractionList(
                    @Query("categoryIds") query: String?,
                    @Query("nlat") nlat: Double?,
                    @Query("elong") elong: Double?,
                    @Query("page") page: Int?): Call<AttractionListData>
}