package com.example.ihc

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.AccountBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class AccountActivity : ComponentActivity() {
    private lateinit var binding: AccountBinding
    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AccountBinding.inflate(layoutInflater)
        auth = Firebase.auth
        setContentView(binding.root)

        binding.back.setOnClickListener{
            val intent = Intent(this@AccountActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.perfil.setOnClickListener{
            val intent = Intent(this@AccountActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.help.setOnClickListener {
            val intent = Intent(this@AccountActivity, HomeActivity::class.java)
            startActivity(intent)
        }
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
    }
}