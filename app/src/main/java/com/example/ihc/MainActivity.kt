package com.example.ihc

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.LoginBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class MainActivity : ComponentActivity() {
    private lateinit var binding: LoginBinding
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        auth = Firebase.auth
        var user = auth.currentUser
        if(user != null){
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }else{
            setContentView(binding.root)
        }


        //Verificação de credenciais
        binding.butLogin.setOnClickListener{
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()


            if(binding.editTextTextEmailAddress.text.isNotEmpty() || binding.editTextTextPassword.text.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this){ signIn ->
                            if(signIn.isSuccessful){
                                Log.d(TAG, "signInWithEmailAndPassword:success")
                                user = auth.currentUser
                                Toast.makeText(this@MainActivity, "Login com sucesso!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                                startActivity(intent)
                            }else{
                                Log.w(TAG, "signInWithEmailAndPassword:failure", signIn .exception)
                                Toast.makeText(this@MainActivity, "Erro! Verifique as suas credenciais", Toast.LENGTH_SHORT).show()
                                binding.editTextTextEmailAddress.text.clear()
                                binding.editTextTextPassword.text.clear()
                            }
                    }

            }else{
                Toast.makeText(this@MainActivity, "Preencha os campos acima para efetuar login!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
