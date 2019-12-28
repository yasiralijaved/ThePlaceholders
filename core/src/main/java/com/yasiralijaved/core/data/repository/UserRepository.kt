package com.yasiralijaved.core.data.repository

import com.google.gson.GsonBuilder
import com.yasiralijaved.core.data.network.PlaceholderService
import com.yasiralijaved.core.data.domain.DomainUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {
    private val webservice: PlaceholderService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(PlaceholderService::class.java)
    }

    companion object {
        private var INSTANCE: UserRepository? = null
        val instance: UserRepository
            @Synchronized get() {
                if (INSTANCE == null) {
                    INSTANCE = UserRepository()
                }
                return INSTANCE as UserRepository
            }
    }

    fun getUsers(): Flow<List<DomainUser>> = flow {
        emit(webservice.users().map { dto ->
            DomainUser(
                id = dto.id,
                name = dto.username ?: "",
                username = dto.username ?: "",
                email = dto.email ?: "",
                phone = dto.phone ?: ""
            )
        })
    }
}