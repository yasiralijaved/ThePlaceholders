package com.yasiralijaved.core.data.network

import retrofit2.http.GET

interface PlaceholderService {
    @GET("users")
    suspend fun users(): List<NetworkUser>
}