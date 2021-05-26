package com.mks.mvvm.di

import com.mks.mvvm.repo.HomeRepository
import com.mks.mvvm.webservice.HomeRemoteDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHomeRepository(homeRemoteService : HomeRemoteDataService) : HomeRepository{
        return HomeRepository(homeRemoteService)
    }
}