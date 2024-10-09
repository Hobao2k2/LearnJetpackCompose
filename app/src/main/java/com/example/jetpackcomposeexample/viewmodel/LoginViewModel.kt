package com.example.jetpackcomposeexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _showPassword = MutableStateFlow(false)
    val showPassword = _showPassword.asStateFlow()

    private val correctEmail = "hobao@gmail.com"
    private val correctPassword = "bao1208"

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }

    fun onTogglePasswordVisibility() {
        _showPassword.value = !_showPassword.value
    }

    fun login(onLoginSuccess: () -> Unit, onLoginError: () -> Unit) {
        viewModelScope.launch {
            if (_email.value == correctEmail && _password.value == correctPassword) {
                onLoginSuccess()
            } else {
                onLoginError()
            }
        }
    }
}