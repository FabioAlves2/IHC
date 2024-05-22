package com.example.ihc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Cacifo3Binding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import kotlin.random.Random

class Cacifo3Activity : ComponentActivity() {

    private lateinit var binding: Cacifo3Binding
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference
    private lateinit var uref: DatabaseReference
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Cacifo3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        database = Firebase.database
        ref = database.getReference("Cacifos")
        uref = database.getReference("Utilizadores")
        auth = Firebase.auth
        var user = auth.currentUser

        val dados = intent.extras
        val num = dados?.getString("num")
        val hours1 = dados?.getString("horas")
        val hours2 = dados?.getString("horas2")

        val mensagem = "O cacifo número $num foi alugado das $hours1 às $hours2"
        binding.textView.text = mensagem

        val codigo=List(6){ Random.nextInt(0,9)}
        val mensagem1 = codigo.joinToString(separator = "")
        binding.textView2.text=mensagem1

        val cacifo = "cacifo$num"


        //Atualizar valores do cacifo
        ref.child(cacifo).child("dispo").setValue(false)
        ref.child(cacifo).child("codigo").setValue(mensagem1)
        ref.child(cacifo).child("horario").setValue("$hours1-$hours2")

        //Associar o cacifo ao utilizador
        if (user != null) {
            uref.child(user.uid).child("cacifo").setValue(cacifo)
        }


        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Cacifo3Activity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.voltar.setOnClickListener {
            val intent = Intent(this@Cacifo3Activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}