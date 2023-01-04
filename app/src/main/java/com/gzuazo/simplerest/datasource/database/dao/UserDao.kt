package com.gzuazo.simplerest.datasource.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gzuazo.simplerest.datasource.database.entities.UserEntity
import com.gzuazo.simplerest.domain.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAll(): LiveData<List<UserEntity>>

    @Delete
    suspend fun delete(user: UserEntity)

}