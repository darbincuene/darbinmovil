package com.luisavillacorte.proyecto.jugador.adapters.model.home

import java.io.Serializable

class Campeonatos (
    val _id: String,
    val nombreCampeonato: String,
    val nombreDisciplinas: String,
    val estadoCampeonato: String,
    val tamanoEquipos: Int,
    val fechaInicio: String,
    val fechaFin: String,
    val tipoCampeonato: String,
    val sede: String,
    val descripcion: String,
    val inicioInscripcion: String,
    val finInscripcion: String,
    val añoCreacion: Int,
    val __v: Int
) :Serializable