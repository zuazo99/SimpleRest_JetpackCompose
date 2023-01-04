package com.gzuazo.simplerest.domain.model

import com.gzuazo.simplerest.datasource.database.entities.UserEntity
import java.net.IDN

data class User(
    val name: String,
    val lastName: String,
    val city: String,
    val thumbnail: String,
    var id: Int
)

fun UserEntity.toDomain() = User(name, lastName, city, thumbnail, id)
