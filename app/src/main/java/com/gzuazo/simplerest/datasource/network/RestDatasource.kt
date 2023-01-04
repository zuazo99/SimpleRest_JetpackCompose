package com.gzuazo.simplerest.datasource.network

import com.gzuazo.simplerest.datasource.network.model.ApiResponse
import retrofit2.http.GET

interface RestDatasource {
    @GET("?inc=name")
    suspend fun getUserName(): ApiResponse

    @GET("?inc=location")
    suspend fun getUserLocation(): ApiResponse

    @GET("?inc=picture")
    suspend fun getUserPicture(): ApiResponse

}