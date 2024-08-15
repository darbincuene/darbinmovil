package com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados

import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.apiPlanillero.VerEquipos.ApiServiceEquipos
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.EquiposAsignadosContract
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.Vs
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class EquiposAsignadosPresenter (
    private val view: EquiposAsignadosContract.View,
    private val equiposAsignadosService: ApiServiceEquipos
): EquiposAsignadosContract.Presenter{
    override fun obtenerEquiposAsignados(idFase: String) {
        val call = equiposAsignadosService.equiposAsignados( idFase)
        call.enqueue(object : Callback<List<Vs>> {
            override fun onResponse(call: Call<List<Vs>>, response: Response<List<Vs>>) {
                if (response.isSuccessful) {
                    val equiposAsignados = response.body()
                    if (equiposAsignados != null) {
                        view.onEquposRecibidos(equiposAsignados)
                    }
                } else {
                    view.error("Failed to retrieve data")
                }
            }
            override fun onFailure(call: Call<List<Vs>>, t: Throwable) {
                view.error(t.message?:"Error interno")
            }
        })
    }
}