package com.gzuazo.simplerest.domain

import com.gzuazo.simplerest.datasource.repository.UserRepository
import javax.inject.Inject

class GetNewUserUseCase @Inject constructor(
    private val userRepo: UserRepository
) {
    suspend operator fun invoke() = userRepo.getNewUser()
}