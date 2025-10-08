package com.rach.udemyteachingjetpackcompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {


    init {
        getData()
    }

    fun getData(){

    }
    private val _email = MutableStateFlow("")
    val email : StateFlow<String> = _email.asStateFlow()


    private val _password = MutableStateFlow("")
    val password : StateFlow<String> = _password.asStateFlow()

    fun onEmailChange(email: String){
        _email.value = email
    }

    fun onPasswordChange(password: String){
        _password.value = password
    }

}