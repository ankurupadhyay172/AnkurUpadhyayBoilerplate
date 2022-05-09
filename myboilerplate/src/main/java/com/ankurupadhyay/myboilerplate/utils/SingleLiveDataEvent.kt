package com.ankurupadhyay.myboilerplate.utils

import androidx.lifecycle.Observer

open class SingleLiveDataEvent<out T>(private val content:T) {
    private var hasBeenHandled = false

//    Returns the content and prevents its use again.

    fun getContentIfNotHandled():T?{
        return if(hasBeenHandled){
            null
        }else{
            hasBeenHandled = true
            content
        }
    }

    fun value() = getContentIfNotHandled()

//    Returns the content, even if it's already been handled

    fun peekContent():T = content

    class SingleLiveObserver<T>(private val onEventUnhandledContent:(T)->Unit):Observer<SingleLiveDataEvent<T>?>{
        override fun onChanged(event: SingleLiveDataEvent<T>?) {
            event?.getContentIfNotHandled()?.let { value->
                onEventUnhandledContent(value)
            }
        }

    }
}