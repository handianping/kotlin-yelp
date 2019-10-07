package com.example.kotlinyelp.data

import com.squareup.moshi.Json

data class Business(
    val name: String,
    val location: Location,
    val alias: String,
    @field:Json(name = "image_url") val image_url: String?,
    val rating: String = ""
)