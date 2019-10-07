package com.example.kotlinyelp.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinessSearch {
    @GET("v3/businesses/search?location=Toronto")
    fun search(@Query("term") term: String): Single<BusinessSearchResponse>
}