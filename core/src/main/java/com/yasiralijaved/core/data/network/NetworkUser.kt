package com.yasiralijaved.core.data.network

import com.google.gson.annotations.SerializedName

// Network DTO
data class NetworkUser (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("phone")
    val phone: String?
)

