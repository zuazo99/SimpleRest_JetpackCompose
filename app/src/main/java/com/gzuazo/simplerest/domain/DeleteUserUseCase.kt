package com.gzuazo.simplerest.domain

import com.gzuazo.simplerest.datasource.database.entities.UserEntity
import com.gzuazo.simplerest.datasource.database.entities.toDatabase
import com.gzuazo.simplerest.datasource.repository.UserRepository
import com.gzuazo.simplerest.domain.model.User
import javax.inject.Inject

class DeleteUserUseCase@Inject constructor(
    private val userRepo: UserRepository
) {

    suspend operator fun invoke(user: User) = userRepo.deleteUser(user.toDatabase())
}