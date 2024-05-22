package com.example.ihc

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Livro2Binding
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class Livro2Activity : ComponentActivity() {

    private lateinit var binding: Livro2Binding
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference
    private lateinit var data: String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Livro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Firebase.database
        ref = database.getReference("Livros")

        setbook("Livro1",binding.clickable,binding.autor,binding.nome,binding.loca)
        setbook("Livro2",binding.clickable2,binding.autor2,binding.nome2,binding.loca2)
        setbook("Livro3",binding.clickable3,binding.autor3,binding.nome3,binding.loca3)

        binding.clickable.setOnClickListener{
            val intent = Intent(this@Livro2Activity, Livro3Activity::class.java)
            intent.putExtra("Livro", "Livro1")
            startActivity(intent)
        }
        binding.clickable2.setOnClickListener{
            Toast.makeText(this@Livro2Activity, "Este livro não se encontra disponível", Toast.LENGTH_SHORT).show()
        }
        binding.clickable3.setOnClickListener{
            Toast.makeText(this@Livro2Activity, "Este livro não se encontra disponível", Toast.LENGTH_SHORT).show()
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Livro2Activity, Livro1Activity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Livro2Activity, ProfileActivity::class.java)
            startActivity(intent)
        }


    }
    private fun setbook(path: String,layout:FrameLayout, autor: TextView, nome: TextView, loca: TextView){
        ref.child(path).get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val bautor = snap.child("autor").value.toString()
                Log.d(TAG, "Value is: " + bautor)
                val bnome = snap.child("nome").value.toString()
                val bloca = snap.child("localizacao").value.toString()
                data = snap.child("data").value.toString()
                layout.visibility= View.VISIBLE
                autor.text = "Autor: $bautor"
                nome.text = "Nome: $bnome"
                loca.text = "Localização: $bloca"
            }else{
                Log.w(TAG, "Failed to read value.")
                Toast.makeText(this@Livro2Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }
    }

}