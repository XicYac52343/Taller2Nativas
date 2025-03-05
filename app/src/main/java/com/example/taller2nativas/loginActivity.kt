package com.example.taller2nativas
import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class loginActivity : AppCompatActivity(){

    private lateinit var et_correo : EditText
    private lateinit var et_contrasena : EditText
    private lateinit var tvNoCuentaRegis : TextView
    private lateinit var tvRecuperarContra : TextView
    private lateinit var bt_ingresar : Button
    private lateinit var sharedPreferences : SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_login)

        Log.d("login Activity", "onCreate: Inicializando el activity de Login")

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        et_correo = findViewById(R.id.et_correo)
        et_contrasena = findViewById(R.id.et_contrasena)
        bt_ingresar = findViewById(R.id.bt_ingresar)
        tvNoCuentaRegis = findViewById(R.id.tvNoCuentaRegis)
        tvRecuperarContra = findViewById(R.id.tvRecuperarContra)


        bt_ingresar.setOnClickListener{
            if(validarDatos()){
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, profileActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Los datos no coinciden", Toast.LENGTH_SHORT).show()
            }
        }

        tvNoCuentaRegis.setOnClickListener{
            var intent = Intent(this, registroActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvRecuperarContra.setOnClickListener{
            var intent = Intent(this, rcpasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("login Activity", "onStart: Va a ser visible el activity de Login")
    }

    override fun onResume() {
        super.onResume()
        Log.d("login Activity", "onResume: Va a estar en primer plano el activity de Login")
    }

    override fun onPause() {
        super.onPause()
        Log.d("login Activity", "onPause: Va a estar en pausa el activity de Login")
    }

    override fun onStop() {
        super.onStop()
        Log.d("login Activity", "onStop: Va a detenerse porque no es visible el activity de Login")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("login Activity", "onDestroy: Va a ser destruido el activity de Login")
    }

    private fun validarDatos() : Boolean{
        val correo = sharedPreferences.getString("correo", "")
        val contrasena = sharedPreferences.getString("contrasena", "")

        val correoText = et_correo.text.toString().trim()
        val contrasenaText = et_contrasena.text.toString().trim()

        if(correo == correoText && contrasena == contrasenaText){
            return true
        }else{
            return false
        }


    }
}