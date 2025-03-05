package com.example.taller2nativas

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class rcpasswordActivity : AppCompatActivity(){
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var et_correoRcPass : EditText
    private lateinit var bt_enviarEnlace : Button
    private lateinit var tvIniciaSesionPass : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(saveInstanceState : Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_rcpassword)

        Log.d("rcPassword Activity", "onCreate: Inicializando el activity de Recuperar Contraseña")

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)


        et_correoRcPass = findViewById(R.id.et_correoRcPass)
        bt_enviarEnlace = findViewById(R.id.bt_enviarEnlace)
        tvIniciaSesionPass = findViewById(R.id.tvIniciaSesionPass)

        bt_enviarEnlace.setOnClickListener{
            if(compararEmail()){
                Toast.makeText(this, "El correo se ha enviado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "El correo es erróneo", Toast.LENGTH_SHORT).show()
            }
        }

        tvIniciaSesionPass.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("rcPassword Activity", "onStart: Va a ser visible el activity de Recuperar Contraseña")
    }

    override fun onResume() {
        super.onResume()
        Log.d("rcPassword Activity", "onResume: Va a estar en primer plano el activity de Recuperar Contraseña")
    }

    override fun onPause() {
        super.onPause()
        Log.d("rcPassword Activity", "onPause: Va a estar en pausa el activity de Recuperar Contraseña")
    }

    override fun onStop() {
        super.onStop()
        Log.d("rcPassword Activity", "onStop: Va a detenerse porque no es visible el activity de Recuperar Contraseña")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("rcPassword Activity", "onDestro: Va a ser destruido el activity de Recuperar Contraseña")
    }


    private fun compararEmail() : Boolean{
        val correo = sharedPreferences.getString("correo", "")

        val correoText = et_correoRcPass.text.toString().trim()

        if(correo == correoText){
            return true
        }else{
            return false
        }
    }

}