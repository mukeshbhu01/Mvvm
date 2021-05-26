package com.mks.mvvm.repo

import com.mks.mvvm.model.Model
import com.mks.mvvm.viewmodel.OperationalCallback
import com.mks.mvvm.webservice.HomeRemoteDataService
import javax.inject.Inject


class HomeRepository @Inject constructor(private val homeDataService : HomeRemoteDataService){

    suspend fun fetchHomeDataSource(callback: OperationalCallback<Model>){
        homeDataService.getHomeDataModel(callback)
    }
}