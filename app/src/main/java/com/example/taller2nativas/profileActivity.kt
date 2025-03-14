package com.example.taller2nativas

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class profileActivity : AppCompatActivity(){

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var tv_nombreUser : TextView
    private lateinit var tv_apellidoUser : TextView
    private lateinit var tv_correoUser : TextView
    private lateinit var tv_numeroUser: TextView
    private lateinit var bt_activityCentral : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(saveInstanceState : Bundle?){
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_profile)

        Log.d("Profile Activity", "onCreate: Inicializando el activity de Profile")

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        tv_nombreUser = findViewById<TextView>(R.id.tv_nombreUser)
        tv_apellidoUser = findViewById(R.id.tv_apellidoUser)
        tv_correoUser = findViewById(R.id.tv_correoUser)
        tv_numeroUser = findViewById(R.id.tv_numeroUser)
        bt_activityCentral = findViewById(R.id.bt_activityCentral)

        tv_nombreUser.text = sharedPreferences.getString("nombre", "")
        tv_apellidoUser.text = sharedPreferences.getString("apellido", "")
        tv_correoUser.text = sharedPreferences.getString("correo", "")
        tv_numeroUser.text = sharedPreferences.getString("telefono", "")

        bt_activityCentral.setOnClickListener{
            val intent = Intent(this, centralActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Profile Activity", "onStart: Va a ser visible el activity de Profile")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Profile Activity", "onResume: Va a estar en primer plano el activity de Profile")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Profile Activity", "onPause: Va a estar en pausa el activity de Profile")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Profile Activity", "onStop: Va a detenerse porque no es visible el activity de Profile")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Profile Activity", "onDestro: Va a ser destruido el activity de Profile")
    }
}