package com.gzuazo.simplerest.datasource.repository

import androidx.lifecycle.LiveData
import com.gzuazo.simplerest.datasource.database.entities.UserEntity
import com.gzuazo.simplerest.domain.model.User

interface UserRepository {
    suspend fun getNewUser(): User
    suspend fun deleteUser(toDelete: UserEntity)
    fun getAllUsers(): LiveData<List<User>>
}

