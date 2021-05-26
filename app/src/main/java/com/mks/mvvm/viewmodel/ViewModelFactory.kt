package com.mks.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mks.mvvm.repo.HomeRepository

class ViewModelFactory(private val repository: HomeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T  =
        modelClass.getConstructor(HomeRepository::class.java).newInstance(repository)

}