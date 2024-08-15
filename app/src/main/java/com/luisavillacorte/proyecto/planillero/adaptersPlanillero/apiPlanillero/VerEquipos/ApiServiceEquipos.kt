package com.luisavillacorte.proyecto.planillero.adaptersPlanillero.apiPlanillero.VerEquipos


import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.Vs
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiServiceEquipos {
    @GET("vs")
    fun equiposAsignados(@Header("IdFase") IdFase:String): Call<List<Vs>>
}