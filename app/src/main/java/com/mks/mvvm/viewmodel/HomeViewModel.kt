package com.mks.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mks.mvvm.repo.HomeRepository
import com.mks.mvvm.model.Model
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(homeRepository: HomeRepository) : ViewModel() {

    private val modelData: MutableLiveData<Model> by lazy {
        MutableLiveData<Model>().also { loadModelData(homeRepository) }
    }
    val uiModelData: LiveData<Model> = modelData

    private fun loadModelData(homeRepository: HomeRepository) {
        viewModelScope.launch(Dispatchers.IO) {
            loadModelDataOffMain(homeRepository)
        }
    }

    private suspend fun loadModelDataOffMain(homeRepository: HomeRepository) {
        homeRepository.fetchHomeDataSource(object : OperationalCallback<Model> {
            override fun onSuccess(t: Model) {
                modelData.value = t
            }

            override fun onError(error: String) {
            }
        })
    }

}