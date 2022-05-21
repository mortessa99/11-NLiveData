package com.example.a11_nlivedata.simple

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val siteName : MutableLiveData<String> by lazy { MutableLiveData<String>() }
}