package com.luisavillacorte.proyecto.jugador.adapters.storage

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {

     private val sharedPreferences: SharedPreferences =
         context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        with(sharedPreferences.edit()) {
            putString("auth_token", token)
            apply()
        }
    }

    fun getToken(): String? {
        return sharedPreferences.getString("auth_token", null)
    }
}