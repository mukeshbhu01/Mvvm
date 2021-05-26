package com.mks.mvvm.webservice

import com.mks.mvvm.viewmodel.OperationalCallback
import com.mks.mvvm.model.Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRemoteDataServiceImpl(apiClient: ApiClient) : HomeRemoteDataService {

    private var service : ApiInterface? = apiClient.buildApiInterface()


    override suspend fun getHomeDataModel(callback: OperationalCallback<Model>) {
        val call: Call<Model>? = service?.getHomeModel(2) // Page no
        call?.enqueue(object : Callback<Model> {
            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                response.body()?.let {
                    if (response.isSuccessful) {
                        callback.onSuccess(it)
                    } else {
                        callback.onError("Error message from data source")
                    }
                }
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                t.message?.let {
                    callback.onError(it)
                }
            }
        }
        )
    }


}