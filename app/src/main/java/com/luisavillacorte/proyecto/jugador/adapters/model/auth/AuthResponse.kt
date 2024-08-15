package com.luisavillacorte.proyecto.jugador.adapters.model.auth

import com.luisavillacorte.proyecto.jugador.adapters.model.auth.User

class AuthResponse (
    val success: Boolean,
    val message: String?,
    val token: String?,
    val user: com.luisavillacorte.proyecto.jugador.adapters.model.auth.User

){
    override fun toString(): String {
        return "AuthResponse(success=$success, message=$message, token=$token, user=$user)"
    }
}
