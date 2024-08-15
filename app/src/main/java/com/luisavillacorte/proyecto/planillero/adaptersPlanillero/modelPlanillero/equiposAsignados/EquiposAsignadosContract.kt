package com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados

import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.Vs


interface EquiposAsignadosContract {
    interface View{
        fun onEquposRecibidos(equiposAsignados: List<Vs>)
        fun error(error: String)
    }
    interface Presenter{
        fun obtenerEquiposAsignados(idFase: String)
    }
}