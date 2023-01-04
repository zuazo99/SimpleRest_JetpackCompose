package com.gzuazo.simplerest.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gzuazo.simplerest.datasource.database.dao.UserDao
import com.gzuazo.simplerest.datasource.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class DbDataSource: RoomDatabase() {

    abstract fun getUserDao(): UserDao
}