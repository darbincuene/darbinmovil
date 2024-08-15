package com.luisavillacorte.proyecto.jugador.adapters.model.crearEquipo

data class JugadorSeleccionado(
    val nombres: String,
    val ficha: String,
    var dorsal: String = "",
    var isSelected: Boolean = false
)
