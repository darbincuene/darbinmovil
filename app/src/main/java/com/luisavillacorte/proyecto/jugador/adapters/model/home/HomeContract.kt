package com.luisavillacorte.proyecto.adapters.model.home

import com.luisavillacorte.proyecto.jugador.adapters.model.auth.PerfilUsuarioResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.home.Campeonatos
import com.luisavillacorte.proyecto.jugador.adapters.model.home.ImagenData

interface HomeContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showCampeonatos(campeonato: List<Campeonatos>)
        fun showError(message: String)
        fun traernombre(perfilUsuarioResponse: PerfilUsuarioResponse)
        fun showImages(images: List<ImagenData>)
    }

    interface Presenter {

        fun getCampeonatos()
        fun getPerfilUsuario()
        fun getImages()
    }
}
