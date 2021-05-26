package com.mks.mvvm.webservice

import com.mks.mvvm.model.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(value = "api/users?")
    fun getHomeModel(@Query(value = "pageNo", encoded = false) pageNo : Int) : Call<Model>
}