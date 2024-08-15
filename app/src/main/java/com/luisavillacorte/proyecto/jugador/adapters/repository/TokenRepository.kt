package com.luisavillacorte.proyecto.jugador.adapters.repository


import com.luisavillacorte.proyecto.jugador.adapters.storage.TokenManager

class TokenRepository(private val tokenManager: TokenManager) {

    fun saveToken(token: String) {
        tokenManager.saveToken(token)
    }

    fun getToken(): String? {
        return  tokenManager.getToken()
    }
}