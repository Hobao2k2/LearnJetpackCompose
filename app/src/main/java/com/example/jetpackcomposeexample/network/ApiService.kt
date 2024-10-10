package com.example.jetpackcomposeexample.network

import com.example.jetpackcomposeexample.model.LoginResponse
import com.example.jetpackcomposeexample.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun loginUser(@Body loginRequest: User): LoginResponse
}