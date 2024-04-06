package com.example.celebritylab2.model.network

import com.example.celebritylab2.model.entity.Celebrity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CelebrityService {


    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")
    @GET("celebrity?name=michael")


    fun fetchCelebrityList(@Query("name") name: String): Call<List<Celebrity>>
}