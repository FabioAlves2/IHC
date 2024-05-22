package com.example.ihc


import android.app.AlertDialog
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
        ref = database.getReference("Cacifo")
        uref = database.getReference("Utilizadores")
        val user = auth.currentUser

        setContentView(binding.root)

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
                    val cacifo = snap.child("cacifo").value.toString()
                    Log.d(ContentValues.TAG, "Value is: $cacifo")
                    if(cacifo!="null"){
                        binding.square1.text= cacifo
                        binding.quadrado.setOnClickListener {
                            val intent = Intent(this@ProfileActivity, PcacifoActivity::class.java)
                            intent.putExtra("path",cacifo)
                            startActivity(intent)
                        }
                    }

                } else {
                    Log.w(ContentValues.TAG, "Failed to read value.")
                    Toast.makeText(this@ProfileActivity, "Erro!", Toast.LENGTH_SHORT).show()
                }
            }

            setContentView(binding.root)

            binding.logout.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Logout")
                builder.setMessage("Quer mesmo fazer logout da sua conta?")
                builder.setPositiveButton("Sim") { _, _ ->
                    // Navigate to MainActivity
                    Firebase.auth.signOut()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                builder.setNegativeButton("Cancelar") { _, _ ->
                    // Do nothing, simply dismiss the dialog
                }
                val dialog = builder.create()
                dialog.show()
            }

            binding.back.setOnClickListener {
                val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
                startActivity(intent)
            }

        }
    }
}