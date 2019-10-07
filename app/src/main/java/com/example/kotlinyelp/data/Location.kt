package com.example.kotlinyelp.data

class Location(
    val address1: String,
    val city: String
) {
    override fun toString() = "$address1, $city"
}