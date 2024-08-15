package com.luisavillacorte.proyecto.jugador.adapters.api.home

import com.luisavillacorte.proyecto.jugador.adapters.model.auth.PerfilUsuarioResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.home.Campeonatos
import com.luisavillacorte.proyecto.jugador.adapters.model.home.ImagenData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface HomeApiService {
    @GET("campeonato")
    fun getCampeonato():Call<List<Campeonatos>>


    @GET("/usuarios/perfil")
    fun obtenerPerfilUsuario(@Header("Authorization") token: String): Call<PerfilUsuarioResponse>
    @GET("photo")
    fun getImages(): Call<List<ImagenData>>


}