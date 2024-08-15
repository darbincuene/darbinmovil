package com.luisavillacorte.proyecto.planillero.viewActivities.verEquiposAsignados

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.RecyclerView
import com.luisavillacorte.proyecto.R
import com.luisavillacorte.proyecto.common.apiRetrofit.RetrofitInstance
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.AdapterEquipos
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.apiPlanillero.VerEquipos.ApiServiceEquipos
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.Vs
import com.luisavillacorte.proyecto.planillero.viewActivities.resultadosEquiposAsignados.fragment_vsResultados
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.EquiposAsignadosContract
import com.luisavillacorte.proyecto.planillero.adaptersPlanillero.modelPlanillero.equiposAsignados.EquiposAsignadosPresenter

class fragment_Planillero : AppCompatActivity(), EquiposAsignadosContract.View {

    private lateinit var presenterEquiposAsig: EquiposAsignadosPresenter

    private lateinit var recycleView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_equipos_asignados)

        recycleView = findViewById(R.id.recycleEquiposAsigandos)
        recycleView.layoutManager = LinearLayoutManager(this);

        val consumoApi = RetrofitInstance.createService(ApiServiceEquipos::class.java)
        presenterEquiposAsig = EquiposAsignadosPresenter(this, consumoApi);

        val IdFase = "66b932df0a23c9561a4d5289"
        presenterEquiposAsig.obtenerEquiposAsignados(IdFase)
    }


    override fun onEquposRecibidos(equiposAsignados: List<Vs>) {
    recycleView.adapter = AdapterEquipos(equiposAsignados, object : AdapterEquipos.OnItemClickListener{
        override fun onItemClick(vs: Vs) {
           val intent = Intent(this@fragment_Planillero, fragment_vsResultados::class.java);
            intent.putExtra("vs", vs);
            startActivity(intent);
        }
    });
    }

    override fun error(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}