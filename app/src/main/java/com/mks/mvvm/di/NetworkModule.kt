package com.mks.mvvm.di

import com.mks.mvvm.webservice.ApiClient
import com.mks.mvvm.webservice.HomeRemoteDataService
import com.mks.mvvm.webservice.HomeRemoteDataServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideHomeRemoteService() : HomeRemoteDataService{
        return HomeRemoteDataServiceImpl(ApiClient)
    }

}