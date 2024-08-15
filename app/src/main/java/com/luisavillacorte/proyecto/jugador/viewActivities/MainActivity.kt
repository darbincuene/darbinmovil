package com.luisavillacorte.proyecto.jugador.viewActivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.luisavillacorte.proyecto.R
import com.luisavillacorte.proyecto.planillero.viewActivities.verEquiposAsignados.fragment_Planillero
import com.luisavillacorte.proyecto.view.activities.fragments.homeFragments.HomeFragment
import com.luisavillacorte.proyecto.jugador.viewActivities.activitiesAuth.ActivityLogin
import com.luisavillacorte.proyecto.jugador.viewActivities.activitiesAuth.RegisterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       setContentView(R.layout.activity_main)
       // setContentView(R.layout.fragment_equipos_asignados)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegister = findViewById<Button>(R.id.btn_register)


        btnLogin.setOnClickListener {
            val loginIntent = Intent(this, ActivityLogin::class.java)
            startActivity(loginIntent)
        }


        btnRegister.setOnClickListener {
            val registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }

    }
}