package com.example.finalproject.network

import java.util.*

data class CountryDetail(
    val ID : Int,
    val Country : String,
    val CountryCode : String,
    val Province : String,
    val City : String,
    val CityCode: String,
    val Lat : Double,
    val Lon : Double,
    val Confirmed : Int,
    val Deaths : Int,
    val Recovered : Int,
    val Active : Int,
    val Date : TimeZone
)
