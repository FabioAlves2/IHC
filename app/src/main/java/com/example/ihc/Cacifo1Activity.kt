package com.example.ihc

import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Cacifo1Binding
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database


class Cacifo1Activity : ComponentActivity() {

    private lateinit var binding: Cacifo1Binding
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Cacifo1Binding.inflate(layoutInflater)
        database = Firebase.database
        ref = database.getReference("Cacifos")

        setdisponi(binding.cacifo1,"cacifo1")
        setdisponi(binding.cacifo2,"cacifo2")
        setdisponi(binding.cacifo3,"cacifo3")
        setdisponi(binding.cacifo4,"cacifo4")
        setdisponi(binding.cacifo5,"cacifo5")
        setdisponi(binding.cacifo6,"cacifo6")
        setdisponi(binding.cacifo7,"cacifo7")
        setdisponi(binding.cacifo8,"cacifo8")
        setdisponi(binding.cacifo9,"cacifo9")
        setdisponi(binding.cacifo10,"cacifo10")
        setdisponi(binding.cacifo11,"cacifo11")
        setdisponi(binding.cacifo12,"cacifo12")

        setContentView(binding.root)

        binding.cacifo1.setOnClickListener {
            click("cacifo1",binding.cacifo1)
        }
        binding.cacifo2.setOnClickListener {
            click("cacifo2",binding.cacifo2)
        }
        binding.cacifo3.setOnClickListener {
            click("cacifo3",binding.cacifo3)
        }
        binding.cacifo4.setOnClickListener {
            click("cacifo4",binding.cacifo4)
        }
        binding.cacifo5.setOnClickListener {
            click("cacifo5",binding.cacifo5)
        }
        binding.cacifo6.setOnClickListener {
            click("cacifo6",binding.cacifo6)
        }
        binding.cacifo7.setOnClickListener {
            click("cacifo7",binding.cacifo7)
        }
        binding.cacifo8.setOnClickListener {
            click("cacifo8",binding.cacifo8)
        }
        binding.cacifo9.setOnClickListener {
            click("cacifo9",binding.cacifo9)
        }
        binding.cacifo10.setOnClickListener {
            click("cacifo10",binding.cacifo10)
        }
        binding.cacifo11.setOnClickListener {
            click("cacifo11",binding.cacifo11)
        }
        binding.cacifo12.setOnClickListener {
            click("cacifo12",binding.cacifo12)
        }
        binding.back.setOnClickListener{
            val intent = Intent(this@Cacifo1Activity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Cacifo1Activity, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
    private fun click(path: String, cacifo: Button){
        ref.child(path).get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val disponibilidade = snap.child("dispo").value
                Log.d(ContentValues.TAG, "Value is: " + disponibilidade)
                if (disponibilidade == true){
                    val intent = Intent(this@Cacifo1Activity, Cacifo2Activity::class.java)
                    intent.putExtra("num", cacifo.text.toString())
                    startActivity(intent)
                }else{
                    Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
                }
            }else{
                Log.w(ContentValues.TAG, "Failed to read value.")
                Toast.makeText(this@Cacifo1Activity, "Erro!", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this@Cacifo1Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}