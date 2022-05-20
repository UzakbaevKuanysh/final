
package com.example.finalproject.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// TODO: Create a property for the base URL provided in the codelab
private const val BASE_URL = "https://api.covid19api.com/"
// TODO: Build the Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// TODO: Build a Retrofit object with the Moshi converter
//pomenyat url


private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface CountriesApiService {
    // TODO: Declare a suspended function to get the list of todos //pomenyat url
    @GET("countries")
    // zdes na Todos
    suspend fun getCountries(): List<Countries>
    
    @GET("country/Benin")
}



// TODO: Create an object that provides a lazy-initialized retrofit service
// zdes na TodosApi
object CountriesApi {
    // zdes na TodosApiService
    val retrofitService : CountriesApiService by lazy {
        retrofit.create(CountriesApiService::class.java)
    }
}
