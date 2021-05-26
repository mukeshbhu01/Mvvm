package com.mks.mvvm.viewmodel

interface OperationalCallback <T> {
    fun onSuccess(t : T)
    fun onError(error : String)
}