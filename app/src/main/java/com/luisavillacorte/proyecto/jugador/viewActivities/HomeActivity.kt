package com.luisavillacorte.proyecto.jugador.viewActivities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luisavillacorte.proyecto.R
import com.luisavillacorte.proyecto.view.activities.fragments.crearEquipoFragments.CrearEquipoFragment
import com.luisavillacorte.proyecto.view.activities.fragments.equipoFragments.EquipoFragment
import com.luisavillacorte.proyecto.view.activities.fragments.homeFragments.HomeFragment
import com.luisavillacorte.proyecto.view.activities.fragments.noticiasFragments.NoticiasFragment
import com.luisavillacorte.proyecto.view.activities.fragments.perfilFragments.PerfilFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.navigation_inicio -> selectedFragment = HomeFragment()
                R.id.navigation_equipo -> selectedFragment = EquipoFragment()
//                R.id.navigation_noticias -> selectedFragment = NoticiasFragment()
                R.id.planilla -> selectedFragment = CrearEquipoFragment()
                 R.id.navigation_perfil -> selectedFragment = PerfilFragment()
            }
            selectedFragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, it).commit()
            }
            true
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            bottomNavigationView.selectedItemId = R.id.navigation_inicio
        }
    }
}