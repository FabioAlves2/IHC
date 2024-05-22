package com.example.ihc

import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Sala2Binding
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database


class Reserva2Activity :  ComponentActivity() {

    private lateinit var binding: Sala2Binding
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Sala2Binding.inflate(layoutInflater)
        database = Firebase.database
        ref = database.getReference("Salas")

        setdisponi(binding.sala1,"sala1")
        setdisponi(binding.sala2,"sala2")
        setdisponi(binding.sala3,"sala3")
        setdisponi(binding.sala4,"sala4")
        setdisponi(binding.sala5,"sala5")
        setdisponi(binding.sala6,"sala6")
        setdisponi(binding.sala7,"sala7")
        setdisponi(binding.sala8,"sala8")

        setContentView(binding.root)

        //recuperar dados
        val dados = intent.extras
        val hours1 = dados?.getString("horas")
        val hours2 = dados?.getString("horas2")

        binding.sala1.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala1",binding.sala1, hours1, hours2)
                }
            }
        }
        binding.sala2.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala2",binding.sala2, hours1, hours2)
                }
            }
        }
        binding.sala3.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala3",binding.sala3, hours1, hours2)
                }
            }
        }
        binding.sala4.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala4",binding.sala4, hours1, hours2)
                }
            }
        }
        binding.sala5.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala5",binding.sala5, hours1, hours2)
                }
            }
        }
        binding.sala6.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala6",binding.sala6, hours1, hours2)
                }
            }
        }
        binding.sala7.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala7",binding.sala7, hours1, hours2)
                }
            }
        }
        binding.sala8.setOnClickListener {
            if (hours1 != null) {
                if (hours2 != null) {
                    click("sala8",binding.sala8, hours1, hours2)
                }
            }
        }
        binding.back.setOnClickListener{
            val intent = Intent(this@Reserva2Activity, ReservaActivity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Reserva2Activity, ProfileActivity::class.java)
            startActivity(intent)
        }

    }
    private fun click(path: String, sala: Button, hours1: String, hours2: String){
        ref.child(path).get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val disponibilidade = snap.child("dispo").value
                Log.d(ContentValues.TAG, "Value is: " + disponibilidade)
                if (disponibilidade == true){
                    val builder = AlertDialog.Builder(this@Reserva2Activity)
                    builder.setTitle("Confirmação")
                    val mensagem = "Quer mesmo reservar a sala " + sala.text.toString() + " das " + hours1 + "-" + hours2 + "?"
                    builder.setMessage(mensagem)
                    builder.setPositiveButton("Sim ") { _, _ ->
                        val intent = Intent(this@Reserva2Activity, Reserva3Activity::class.java)
                        startActivity(intent)
                    }
                    builder.setNegativeButton("Cancelar") { _, _ ->

                    }
                    val dialog = builder.create()
                    dialog.show()
                }else{
                    Toast.makeText(this@Reserva2Activity, "Sala não disponível no horário selecionado", Toast.LENGTH_SHORT).show()
                }
            }else{
                Log.w(ContentValues.TAG, "Failed to read value.")
                Toast.makeText(this@Reserva2Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun setdisponi(sala: Button, path: String) {
        ref.child(path).get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val disponibilidade = snap.child("dispo").value
                Log.d(ContentValues.TAG, "Value is: " + disponibilidade)
                if (disponibilidade == true){
                    sala.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_green, 0, 0, 0) // Set green circle drawable
                }else{
                    sala.setCompoundDrawablesWithIntrinsicBounds(R.drawable.circle_red, 0, 0, 0) // Set red circle drawable
                }
            }else{
                Log.w(ContentValues.TAG, "Failed to read value.")
                Toast.makeText(this@Reserva2Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }

    }

}


