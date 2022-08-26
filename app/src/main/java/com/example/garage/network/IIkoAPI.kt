package com.example.garage.network

import com.example.garage.model.Menu
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST

interface IIkoAPI {
    @Headers("Content-Type: application/json")
    @POST("/nomenclature")
    suspend fun getMenu() : Response<Menu>
}