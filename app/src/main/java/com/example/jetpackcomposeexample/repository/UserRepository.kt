package com.example.jetpackcomposeexample.repository

import com.example.jetpackcomposeexample.model.LoginResponse
import com.example.jetpackcomposeexample.model.User
import com.example.jetpackcomposeexample.network.RetrofitInstance

class UserRepository {
    private val api = RetrofitInstance.getRetrofitClient();

    suspend fun loginUser(user:User) : LoginResponse {
        return api.loginUser(user)
    }
}