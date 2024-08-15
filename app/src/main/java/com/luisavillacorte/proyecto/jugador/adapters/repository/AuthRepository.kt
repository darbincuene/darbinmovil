package com.luisavillacorte.gosport.adapters.api.repository

import com.luisavillacorte.proyecto.jugador.adapters.api.authService.ApiService
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.AuthResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.EmailCheckRequest
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.IdentificacionCheckRequest
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository(private val ApiService: com.luisavillacorte.proyecto.jugador.adapters.api.authService.ApiService) {}

//    fun checkEmailExists(correo: String, callback: (Boolean) -> Unit) {
//        val request = EmailCheckRequest(correo)
//        val call = ApiService.verifyEmail(request)
//        call.enqueue(object : Callback<AuthResponse> {
//            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                if (response.isSuccessful) {
//                    val emailExists = response.body()?.emailExists ?: false
//                    callback(emailExists)
//                } else {
//                    callback(false)
//                }
//            }
//
//            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                callback(false)
//            }
//        })
//    }
//
//    fun checkIdentificationExists(identificacion: String, callback: (Boolean) -> Unit) {
//        val request = IdentificacionCheckRequest(identificacion = identificacion)
//        val call = ApiService.verifyIdentification(request)
//        call.enqueue(object : Callback<AuthResponse> {
//            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
//                if (response.isSuccessful) {
//                    val identificationExists = response.body()?.identificationExists ?: false
//                    callback(identificationExists)
//                } else {
//                    callback(false)
//                }
//            }
//
//            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
//                callback(false)
//            }
//        })
//    }
//}