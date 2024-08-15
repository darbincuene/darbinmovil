package com.luisavillacorte.proyecto.adapters.model.home

import android.util.Log
import com.luisavillacorte.proyecto.jugador.adapters.api.home.HomeApiService
import com.luisavillacorte.proyecto.jugador.adapters.model.auth.PerfilUsuarioResponse
import com.luisavillacorte.proyecto.jugador.adapters.model.home.Campeonatos
import com.luisavillacorte.proyecto.jugador.adapters.storage.TokenManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import android.content.Context
import com.luisavillacorte.proyecto.jugador.adapters.api.formCrearEquipo.CrearEquipoApiService
import com.luisavillacorte.proyecto.jugador.adapters.model.crearEquipo.CrearEquipoContract
import com.luisavillacorte.proyecto.jugador.adapters.model.home.ImagenData

class HomePresenter(
    private val view: HomeContract.View,
    private val context: Context,
    private val apiService: HomeApiService
) : HomeContract.Presenter {

    private val tokenManager = TokenManager(context)
    private val TAG = "HomePresenter"

    override fun getPerfilUsuario() {
        val token = tokenManager.getToken() ?: return view.showError("Token no disponible")
        Log.d(TAG, "Token obtenido: $token")
        val call = apiService.obtenerPerfilUsuario("Bearer $token")
        call.enqueue(object : Callback<PerfilUsuarioResponse> {
            override fun onResponse(
                call: Call<PerfilUsuarioResponse>,
                response: Response<PerfilUsuarioResponse>
            ) {
                if (response.isSuccessful) {
                    val perfil = response.body()
                    if (perfil != null) {
                        view.traernombre(perfil)
                    } else {
                        view.showError("Perfil de usuario vacío")
                    }
                } else {
                    view.showError("Error al obtener el perfil ${response.code()}: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PerfilUsuarioResponse>, t: Throwable) {
                view.showError(t.message ?: "Error desconocido")
            }
        })
    }

    override fun getImages() {
        view.showLoading()
        Log.d(TAG, "Fetching images from API")
        val call = apiService.getImages()
        call.enqueue(object : Callback<List<ImagenData>> {
            override fun onResponse(
                call: Call<List<ImagenData>>,
                response: Response<List<ImagenData>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { images ->
                        view.showImages(images)
                        Log.d(TAG, "Images fetched and shown: ${images.size}")
                    }
                } else {
                    view.showError("Error: ${response.code()}")
                    Log.e(TAG, "Error response code: ${response.code()}")
                }
                view.hideLoading()
            }

            override fun onFailure(call: Call<List<ImagenData>>, t: Throwable) {
                view.hideLoading()
                view.showError(t.message ?: "Error desconocido")
                Log.e(TAG, "API call failed: ${t.message}")
            }
        })
    }

    override fun getCampeonatos() {
        view.showLoading()
        Log.d(TAG, "Fetching campeonatos from API")
        val call = apiService.getCampeonato()
        call.enqueue(object : Callback<List<Campeonatos>> {
            override fun onResponse(
                call: Call<List<Campeonatos>>,
                response: Response<List<Campeonatos>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { campeonatos ->
                        // Filtrar los campeonatos por los estados 'Inscripción' o 'Ejecución'
                        val campeonatosFiltrados = campeonatos.filter {
                            it.estadoCampeonato == "Ejecucion" || it.estadoCampeonato == "Inscripcion"
                        }

                        // Mostrar solo los campeonatos filtrados
                        view.showCampeonatos(campeonatosFiltrados)
                        Log.d(TAG, "Campeonatos filtered and shown: ${campeonatosFiltrados.size}")
                    }
                } else {
                    view.showError("Error: ${response.code()}")
                    Log.e(TAG, "Error response code: ${response.code()}")
                }
                view.hideLoading()
            }

            override fun onFailure(call: Call<List<Campeonatos>>, t: Throwable) {
                view.hideLoading()
                view.showError(t.message ?: "Error desconocido")
                Log.e(TAG, "API call failed: ${t.message}")
            }
        })
    }
}
