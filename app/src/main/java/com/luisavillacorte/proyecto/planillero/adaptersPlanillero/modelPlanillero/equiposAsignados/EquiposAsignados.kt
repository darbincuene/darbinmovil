package com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados

import java.io.Serializable

class Vs (
    val id: String,
    val equipo1: InscripcionEquipos,
    val equipo2: InscripcionEquipos,
    val IdFase : String,
    val fecha: String? = null,
    val hora: String? =  null,
    val estado: Boolean? = null,
    ): Serializable
class Equipo(
    val id: String,
    val nombreEquipo: String,
    val nombreCapitan: String,
    val contactoUno: String,
    val contactoDos: String,
    val jornada: String,
    val cedula: String,
    val imgLogo: String,
    val estado: Boolean,
    val participantes : List<Participantes>
)
class Participantes(
    val id: String,
    val nombreJugador: String,
    val ficha: Int,
    val dorsal: Int
)
class InscripcionEquipos(
    val informacion: Informacion,
)
class Informacion(
    val team1: Team,
    val team2: Team
)
class Team(
    val id: String,
    val Equipo: Equipo,
    val idCampeonato: String
)