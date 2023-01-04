package com.gzuazo.simplerest.di

import com.gzuazo.simplerest.datasource.network.RestDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    // Proveo la URL
    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl() = "https://randomuser.me/api/"

    // Proveo Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl")baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Proveo la restApi
    @Singleton
    @Provides
    fun provideRestDataSource(retrofit: Retrofit): RestDatasource {
        return retrofit.create(RestDatasource::class.java)
    }
}