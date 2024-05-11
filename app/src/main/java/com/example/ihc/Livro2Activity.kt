package com.example.ihc

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
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
    private lateinit var localizacao: String

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Livro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Firebase.database
        ref = database.getReference("Livros")
        ref.child("Livro1").get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val autor = snap.child("autor").value.toString()
                Log.d(TAG, "Value is: " + autor)
                val nome = snap.child("nome").value.toString()
                val data = snap.child("data").value.toString()
                localizacao = snap.child("localizacao").value.toString()
                binding.autor.text = "Autor: $autor"
                binding.nome.text = "Nome: $nome"
                binding.data.text = "Data: $data"
            }else{
                Log.w(TAG, "Failed to read value.")
                Toast.makeText(this@Livro2Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }
        ref.child("Livro2").get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val autor = snap.child("autor").value.toString()
                Log.d(TAG, "Value is: " + autor)
                val nome = snap.child("nome").value.toString()
                val data = snap.child("data").value.toString()
                binding.autor2.text = "Autor: $autor"
                binding.nome2.text = "Nome: $nome"
                binding.data2.text = "Data: $data"
            }else{
                Log.w(TAG, "Failed to read value.")
                Toast.makeText(this@Livro2Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }
        ref.child("Livro3").get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val snap = task.result
                val autor = snap.child("autor").value.toString()
                Log.d(TAG, "Value is: " + autor)
                val nome = snap.child("nome").value.toString()
                val data = snap.child("data").value.toString()
                binding.clickable3.visibility= View.VISIBLE
                binding.autor3.text = "Autor: $autor"
                binding.nome3.text = "Nome: $nome"
                binding.data3.text = "Data: $data"
            }else{
                Log.w(TAG, "Failed to read value.")
                Toast.makeText(this@Livro2Activity, "Erro!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.clickable.setOnClickListener{
            val intent = Intent(this@Livro2Activity, Livro3Activity::class.java)
            intent.putExtra("Autor", binding.autor.text.toString().trim())
            intent.putExtra("Nome", binding.nome.text.toString().trim())
            intent.putExtra("Data", binding.data.text.toString().trim())
            intent.putExtra("loca", localizacao)
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
            val intent = Intent(this@Livro2Activity, AccountActivity::class.java)
            startActivity(intent)
        }


    }

}