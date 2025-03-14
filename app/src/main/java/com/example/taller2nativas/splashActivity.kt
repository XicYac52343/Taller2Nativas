package com.example.taller2nativas

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.view.View
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


/*App Compat compacta todo como si fuera una captura de pantalla*/
class splashActivity : AppCompatActivity() {

    //Ciclos de vida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Log.d("Splash Activity", "onCreate: Inicializando el activity de Splash")

        Handler(Looper.getMainLooper()).postDelayed({

            //Intent se usa para enviar mensajes o cambiar de activity, pero sirve para más funciones
            val intent = Intent(this,homeActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Splash Activity", "onStart: Va a ser visible el activity de Splash")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Splash Activity", "onResume: Va a estar en primer plano el activity de Splash")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Splash Activity", "onPause: Va a estar en pausa el activity de Splash")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Splash Activity", "onStop: Va a detenerse porque no es visible el activity de Splash")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Splash Activity", "onDestro: Va a ser destruido el activity de Splash")
    }
}