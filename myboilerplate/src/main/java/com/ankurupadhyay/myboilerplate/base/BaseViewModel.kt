package com.ankurupadhyay.myboilerplate.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ankurupadhyay.myboilerplate.utils.SingleLiveDataEvent

open class BaseViewModel: ViewModel() {
    private var loading:MutableLiveData<SingleLiveDataEvent<Boolean>> = MutableLiveData()

    fun getLoading() = loading

    fun setLoading(visible:Boolean){
        loading.value = SingleLiveDataEvent(visible)
    }

}