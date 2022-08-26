package com.example.garage.repository

import com.example.garage.model.Menu
import com.example.garage.network.NetworkController
import retrofit2.Response

class MenuRepository {
    suspend fun getMenu() : Response<Menu>{
        return NetworkController.getIIkoApi().getMenu()
    }
}