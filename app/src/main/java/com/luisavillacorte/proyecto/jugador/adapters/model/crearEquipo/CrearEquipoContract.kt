package com.luisavillacorte.proyecto.jugador.adapters.model.crearEquipo

import com.luisavillacorte.proyecto.jugador.adapters.model.auth.PerfilUsuarioResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.User

interface CrearEquipoContract {

    interface View {
        fun showLoading(isLoading: Boolean)
//        fun hideLoading()
        fun showError(message: String)
        fun showSuccess(message: String)
        fun validateFields(): Boolean
        fun getSelectedPlayers(): List<com.luisavillacorte.proyecto.jugador.adapters.model.auth.User>
        fun showJugadores(jugadores: List<com.luisavillacorte.proyecto.jugador.adapters.model.auth.User>)
        fun showPerfilUsuario(perfil: com.luisavillacorte.proyecto.jugador.adapters.model.auth.PerfilUsuarioResponse)
//        fun onEquipoCreado(crearEquipoResponse: CrearEquipoResponse?)

    }

    interface Presenter {
        fun getPerfilUsuario()
        fun crearEquipo(equipo: com.luisavillacorte.proyecto.jugador.adapters.model.crearEquipo.Equipo)
        fun buscarJugadores(identificacion: String)

    }
}