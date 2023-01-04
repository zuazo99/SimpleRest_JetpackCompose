package com.gzuazo.simplerest.di

import com.gzuazo.simplerest.datasource.repository.UserRepository
import com.gzuazo.simplerest.datasource.repository.UserRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun userRepository(repo: UserRepositoryImp): UserRepository

}