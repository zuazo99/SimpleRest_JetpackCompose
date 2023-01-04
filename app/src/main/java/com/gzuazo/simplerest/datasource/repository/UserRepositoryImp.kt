package com.gzuazo.simplerest.datasource.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.gzuazo.simplerest.datasource.database.dao.UserDao
import com.gzuazo.simplerest.datasource.database.entities.UserEntity
import com.gzuazo.simplerest.datasource.network.RestDatasource
import com.gzuazo.simplerest.domain.model.User
import com.gzuazo.simplerest.domain.model.toDomain
import kotlinx.coroutines.delay
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val datasource: RestDatasource,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun getNewUser(): User {
        val name = datasource.getUserName().results[0].name!!
        val location = datasource.getUserLocation().results[0].location!!
        val picture = datasource.getUserPicture().results[0].picture!!
        val userEntity = UserEntity(
            name = name.first,
            lastName = name.last,
            city = location.city,
            thumbnail = picture.thumbnail
        )
        userDao.insert(userEntity)
        return userEntity.toDomain()
    }


    override suspend fun deleteUser(toDelete: UserEntity) = userDao.delete(toDelete)

    override fun getAllUsers(): LiveData<List<User>> = userDao.getAll().map { users ->
        users.map {
            it.toDomain()
        }
    }
}