package com.mks.mvvm.webservice

import com.mks.mvvm.viewmodel.OperationalCallback
import com.mks.mvvm.model.Model

interface HomeRemoteDataService {
    suspend fun getHomeDataModel(callback: OperationalCallback<Model>)
}