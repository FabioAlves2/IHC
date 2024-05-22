package com.example.ihc

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.PcacifoBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class PcacifoActivity : ComponentActivity() {

    private lateinit var binding: PcacifoBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference
    private lateinit var uref: DatabaseReference
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PcacifoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        database = Firebase.database
        ref = database.getReference("Cacifos")
        uref = database.getReference("Utilizadores")
        auth = Firebase.auth
        var user = auth.currentUser

        val dados = intent.extras
        val path = dados?.getString("path")

        if (path != null) {
            ref.child(path).get().addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val snap = task.result
                    val codigo = snap.child("codigo").value.toString()
                    Log.d(ContentValues.TAG, "Value is: $codigo")
                    val horario = snap.child("horario").value.toString()
                    binding.NameText.text=path
                    binding.textView.text="Este cacifo foi alugado das $horario.\nPara desbloquear use o seguinte códgio:"
                    binding.textView2.text=codigo
                }else{
                    Log.w(ContentValues.TAG, "Failed to read value.")
                    Toast.makeText(this@PcacifoActivity, "Erro!", Toast.LENGTH_SHORT).show()
                }
            }
        }



        binding.back.setOnClickListener {
            val intent = Intent(this@PcacifoActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.voltar.setOnClickListener {
            val intent = Intent(this@PcacifoActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}