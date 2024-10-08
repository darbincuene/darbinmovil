package com.luisavillacorte.proyecto.view.activities.fragments.homeFragments

import CampeonatosAdapter
import ImageAdapter
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luisavillacorte.proyecto.R
import com.luisavillacorte.proyecto.adapters.model.home.HomeContract
import com.luisavillacorte.proyecto.adapters.model.home.HomePresenter
import com.luisavillacorte.proyecto.common.apiRetrofit.RetrofitInstance
import com.luisavillacorte.proyecto.jugador.adapters.api.formCrearEquipo.CrearEquipoApiService
import com.luisavillacorte.proyecto.jugador.adapters.api.home.HomeApiService
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.PerfilUsuarioResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.home.Campeonatos
import com.luisavillacorte.proyecto.jugador.adapters.model.home.ImagenData

class HomeFragment() : Fragment(), HomeContract.View {

    private lateinit var presenter: HomePresenter
    private lateinit var recyclerViewCampeonatos: RecyclerView
    private lateinit var recyclerViewImages: RecyclerView
    private lateinit var campeonatosAdapter: CampeonatosAdapter
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var nombrejuga: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewCampeonatos = view.findViewById(R.id.recyclerViewCampeonatos)
        recyclerViewImages = view.findViewById(R.id.recyclerViewImages)
        nombrejuga = view.findViewById(R.id.nombreusuario)

        // Configura el layout manager para mostrar los items horizontalmente
        recyclerViewCampeonatos.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewImages.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Inicializar presenter con RetrofitInstance
        presenter = HomePresenter(
            this, requireContext(),
            RetrofitInstance.createService(HomeApiService::class.java)
        )

        presenter.getCampeonatos()
        presenter.getPerfilUsuario()
        presenter.getImages()
    }

    override fun showLoading() {
        // Muestra un indicador de carga si es necesario
    }

    override fun hideLoading() {
        // Oculta el indicador de carga si es necesario
    }

    override fun showCampeonatos(campeonatos: List<Campeonatos>) {
        if (campeonatos.isNotEmpty()) {
            campeonatosAdapter = CampeonatosAdapter(campeonatos)
            recyclerViewCampeonatos.adapter = campeonatosAdapter
        } else {
            Toast.makeText(context, "No hay campeonatos disponibles", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showImages(images: List<ImagenData>) {
        if (images.isNotEmpty()) {
            imageAdapter = ImageAdapter(images)
            recyclerViewImages.adapter = imageAdapter
        } else {
            Toast.makeText(context, "No hay imágenes disponibles", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showError(message: String) {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        } ?: run {
            Log.e("HomeFragment", "Context is null, cannot show toast")
        }
    }


    override fun traernombre(perfilUsuarioResponse: PerfilUsuarioResponse) {
        val nombreJugador = perfilUsuarioResponse.nombres
        nombrejuga.text = "Hola $nombreJugador, Bienvenido a GoSport"
        Log.d("HomeFragment", "Nombre del usuario: $nombreJugador")
    }
}