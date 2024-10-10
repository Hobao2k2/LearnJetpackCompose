package com.example.jetpackcomposeexample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeexample.model.LoginResponse
import com.example.jetpackcomposeexample.model.User
import com.example.jetpackcomposeexample.repository.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _showPassword = MutableStateFlow(false)
    val showPassword = _showPassword.asStateFlow()

    private val correctEmail = "hobao@gmail.com"
    private val correctPassword = "bao1208"

    private val _loginResult = MutableStateFlow<LoginResponse?>(null)
    val loginResult = _loginResult.asStateFlow()


    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onTogglePasswordVisibility() {
        _showPassword.value = !_showPassword.value
    }

    fun login(user: User): Job {
        return viewModelScope.launch {
            Log.i("test","bat dau lay du lieu tu repository")
            val loginUser=userRepository.loginUser(user)
            Log.i("test","dang chuan bị cap nhat dư lieu vao _loginResult")
            _loginResult.value=loginUser
            Log.i("test","da cap nhat dư lieu vao _loginResult")
        }
    }
}