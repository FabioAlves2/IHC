package com.example.ihc


import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.PerfilBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class ProfileActivity : ComponentActivity() {
    private lateinit var binding: PerfilBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var uref: DatabaseReference
    private lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PerfilBinding.inflate(layoutInflater)
        auth = Firebase.auth
        database = Firebase.database
        uref = database.getReference("Utilizadores")
        val user = auth.currentUser

        setContentView(binding.root)

        //Associar o cacifo ao utilizador
        if (user != null) {
            uref.child(user.uid).get().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val snap = task.result
                    val nome = snap.child("nome").value.toString()
                    Log.d(ContentValues.TAG, "Value is: $nome")
                    val email = snap.child("email").value.toString()
                    val telefone = snap.child("telefone").value.toString()
                    binding.NomeText.text=nome
                    binding.emailText.text=email
                    binding.telefoneText.text=telefone
                } else {
                    Log.w(ContentValues.TAG, "Failed to read value.")
                    Toast.makeText(this@ProfileActivity, "Erro!", Toast.LENGTH_SHORT).show()
                }
            }
            setContentView(binding.root)

            binding.back.setOnClickListener {
                val intent = Intent(this@ProfileActivity, AccountActivity::class.java)
                startActivity(intent)
            }

        }
    }
}