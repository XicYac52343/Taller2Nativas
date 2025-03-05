package com.example.taller2nativas

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class registroActivity : AppCompatActivity() {
    /*
    private lateinit var editTextNombres : EditText
    private lateinit var buttonRegistro : Button*/

    private lateinit var sharedPreferences: SharedPreferences


    private lateinit var et_nombreRegistro : EditText
    private lateinit var et_apellidoRegistro : EditText
    private lateinit var et_correoRegistro : EditText
    private lateinit var et_telefonoRegistro : EditText
    private lateinit var et_contrasenaRegistro : EditText
    private lateinit var et_rpContrasenaRegistro : EditText
    private lateinit var tvIniciaSesionRegis : TextView
    private lateinit var cb_terminosCondiciones : CheckBox

    private lateinit var bt_registrateRegis : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(saveInstanceState: Bundle?){

        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("Registro Activity", "onCreate: Inicializando el activity de registro")

        et_nombreRegistro = findViewById(R.id.et_nombreRegistro)
        et_apellidoRegistro = findViewById(R.id.et_apellidoRegistro)
        et_correoRegistro = findViewById(R.id.et_correoRegistro)
        et_telefonoRegistro = findViewById(R.id.et_telefonoRegistro)
        et_contrasenaRegistro = findViewById(R.id.et_contrasenaRegistro)
        et_rpContrasenaRegistro = findViewById(R.id.et_rpContrasenaRegistro)
        cb_terminosCondiciones = findViewById(R.id.cb_terminosCondiciones)

        tvIniciaSesionRegis = findViewById(R.id.tvIniciaSesionRegis)
        bt_registrateRegis = findViewById(R.id.bt_registrateRegis)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)


        bt_registrateRegis.setOnClickListener{
            if(validarCampos()){
                guardarDatos()
                val intent = Intent(this, loginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        tvIniciaSesionRegis.setOnClickListener{
            var intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validarCampos() : Boolean{
        val nombre = et_nombreRegistro.text.toString().trim()
        val apellido = et_apellidoRegistro.text.toString().trim()
        val correo = et_correoRegistro.text.toString().trim()
        val telefono = et_telefonoRegistro.text.toString().trim()
        val contrasena = et_contrasenaRegistro.text.toString().trim()
        val rpcontrasena = et_rpContrasenaRegistro.text.toString().trim()
        val terminos = cb_terminosCondiciones.isChecked

        if(nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contrasena.isEmpty() || rpcontrasena.isEmpty()){
            Toast.makeText(this,"El campo es obligatorio", Toast.LENGTH_SHORT).show()
            return false
        }else if(contrasena != rpcontrasena) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }else if(!terminos){
            Toast.makeText(this,"Acepta los terminos y condiciones", Toast.LENGTH_SHORT).show()
            return false
        }else{
            return true
        }
    }

    private fun guardarDatos(){
        val editor = sharedPreferences.edit()

        editor.putString("nombre",et_nombreRegistro.text.toString().trim())
        editor.putString("apellido", et_apellidoRegistro.text.toString().trim())
        editor.putString("correo", et_correoRegistro.text.toString().trim())
        editor.putString("telefono", et_telefonoRegistro.text.toString().trim())
        editor.putString("contrasena", et_contrasenaRegistro.text.toString().trim())
        editor.putString("rpcontrasena", et_rpContrasenaRegistro.text.toString().trim())
        editor.apply()

        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Registro Activity", "onStart: Va a ser visible el activity de Registro")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Registro Activity", "onResume: Va a estar en primer plano el activity de Registro")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Registro Activity", "onPause: Va a estar en pausa el activity de Registro")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Registro Activity", "onStop: Va a detenerse porque no es visible el activity de Registro")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Registro Activity", "onDestro: Va a ser destruido el activity de Registro")
    }
    
    /*
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("Registro Activity ", "onCreate: Inicializando el activity de registro")

        //Buscar componente por ID
        editTextNombres = findViewById(R.id.et_correo)
        buttonRegistro = findViewById(R.id.bt_comenzar)

        //Archivo de almacenamiento local
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonRegistro.setOnClickListener{
            //Validar Campos
            if(validarCampos()){
                //Guardar Datos
                guardarDatos()
                //Redireccionar
                val intent = Intent(this, loginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    //Fun es funcion
    private fun validarCampos() : Boolean{
        val nombres  = editTextNombres.text.toString().trim()

        if(nombres.isEmpty()){
            Toast.makeText(this,"El campo es obligatorio", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun guardarDatos(){
        val editor = sharedPreferences.edit()
        //Clave - COntenido
        editor.putString("nombre", editTextNombres.text.toString().trim())
        editor.apply()

        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()

    }
    /*
    //COmo llamar los datos
    private fun cargarDatosUsuario(){
        val nombres = sharedPreferences.getString("nombre", "")

        textViewNombres.text = nombres;
    }*/*/
}

