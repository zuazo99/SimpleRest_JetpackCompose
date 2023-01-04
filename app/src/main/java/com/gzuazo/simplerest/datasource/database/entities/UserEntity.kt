package com.gzuazo.simplerest.datasource.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gzuazo.simplerest.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "thumbnail") val thumbnail: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)

fun User.toDatabase() =
    UserEntity(name = name, lastName = lastName, city = city, thumbnail = thumbnail, id = id)
