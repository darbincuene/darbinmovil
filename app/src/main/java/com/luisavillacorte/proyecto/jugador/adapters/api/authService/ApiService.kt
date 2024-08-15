package com.luisavillacorte.proyecto.jugador.adapters.api.authService

import com.luisavillacorte.proyecto.jugador.adapters.model.auth.User
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.AuthResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.EmailCheckRequest
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.IdentificacionCheckRequest
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.LoginCredentials
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

@POST("auth/register")
    fun registerUser(@Body user: com.luisavillacorte.proyecto.jugador.adapters.model.auth.User): Call<com.luisavillacorte.proyecto.jugador.adapters.model.auth.AuthResponse>

    @POST("auth/login")
    fun loginUser(@Body loginRequest: com.luisavillacorte.proyecto.jugador.adapters.model.auth.LoginCredentials): Call<com.luisavillacorte.proyecto.jugador.adapters.model.auth.AuthResponse>

//    @POST("auth/register") // Usar el mismo endpoint para verificación
//    fun verifyEmail(@Body emailRequest: EmailCheckRequest): Call<AuthResponse>
//
//    @POST("auth/register") // Usar el mismo endpoint para verificación
//    fun verifyIdentification(@Body identificationRequest: IdentificacionCheckRequest): Call<AuthResponse>
}
