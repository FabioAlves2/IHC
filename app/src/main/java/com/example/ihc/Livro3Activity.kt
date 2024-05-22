package com.example.ihc

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Livro3Binding
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class Livro3Activity : ComponentActivity() {

    private lateinit var binding: Livro3Binding
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Livro3Binding.inflate(layoutInflater)
        database = Firebase.database
        ref = database.getReference("Livros")
        setContentView(binding.root)


        val dados = intent.extras
        val path = dados?.getString("Livro")
        if (path != null) {
            ref.child(path).get().addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val snap = task.result
                    val bautor = snap.child("autor").value.toString()
                    Log.d(ContentValues.TAG, "Value is: " + bautor)
                    val bnome = snap.child("nome").value.toString()
                    val bloca = snap.child("localizacao").value.toString()
                    val data = snap.child("data").value.toString()
                    val mensagem = "O livro $bnome do autor $bautor lançado em $data encontra-se disponível no:"
                    binding.textView.text = mensagem
                    val piso = bloca.split("-")[0].trim()
                    val estante = bloca.split("-")[1].trim()
                    val prateleira = bloca.split("-")[2].trim()
                    val mensagem2 = "Piso: $piso \n Estante: $estante\n Prateleira: $prateleira"
                    binding.textView2.text = mensagem2
                }else{
                    Log.w(ContentValues.TAG, "Failed to read value.")
                    Toast.makeText(this@Livro3Activity, "Erro!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.reservar.setOnClickListener {
            Toast.makeText(this@Livro3Activity, "Processo em desenvolvimento", Toast.LENGTH_SHORT).show()
        }
        binding.mapa.setOnClickListener {
            val intent = Intent(this@Livro3Activity, MapaActivity::class.java)
            startActivity(intent)
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Livro3Activity, Livro1Activity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Livro3Activity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.voltar.setOnClickListener {
            val intent = Intent(this@Livro3Activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}