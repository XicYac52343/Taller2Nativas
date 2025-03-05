package com.example.taller2nativas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.content.SharedPreferences
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.prefs.Preferences
import androidx.appcompat.app.AppCompatActivity




class homeActivity : AppCompatActivity(){

    private lateinit var tvRegistro : TextView
    private lateinit var buttonComienza : Button


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Log.d("Home Activity", "onCreate: Inicializando el activity de Home")

        //buttonComienza = findViewById(R.id.bt_comenzar)
        tvRegistro = findViewById(R.id.tvRegistrate)
        buttonComienza = findViewById(R.id.bt_comenzar)

        buttonComienza.setOnClickListener{
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvRegistro.setOnClickListener{
            val intent = Intent(this, registroActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Home Activity", "onStart: Va a ser visible el activity de Home")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Home Activity", "onResume: Va a estar en primer plano el activity de Home")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Home Activity", "onPause: Va a estar en pausa el activity de Home")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Home Activity", "onStop: Va a detenerse porque no es visible el activity de Home")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Home Activity", "onDestro: Va a ser destruido el activity de Home")
    }
}