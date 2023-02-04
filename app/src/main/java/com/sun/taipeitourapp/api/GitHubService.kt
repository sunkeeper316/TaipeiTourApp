package com.sun.taipeitourapp.api

import com.sun.taipeitourapp.model.AttractionListData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("/Attractions/All")
    fun getUserList(@Query("q") query: String,
                    @Query("page") page: Int,
                    @Query("per_page") pageSize: Int): Call<AttractionListData>
}