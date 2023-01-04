package com.gzuazo.simplerest.domain

import com.gzuazo.simplerest.datasource.repository.UserRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke() = repository.getAllUsers()
}