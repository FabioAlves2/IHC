package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ihc.databinding.LoginBinding
import com.example.ihc.ui.theme.IHCTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Verificação de credenciais
        binding.butLogin.setOnClickListener{
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextTextPassword.text.toString().trim()

            if (email.endsWith("@ua.pt")){
                if (password == "1234"){
                    binding.errLogin.text="Login Sucessido"
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
                else if(password==""){
                    binding.errLogin.text="Por favor, insira a sua password."
                    binding.editTextTextPassword.text.clear()
                }
                else{
                    binding.errLogin.text="A palavra passe inserida é incorreta."
                    binding.editTextTextPassword.text.clear()
                }
            }
            else{
                binding.errLogin.text="O email inserido não pertence à instituição."
                binding.editTextTextEmailAddress.text.clear()
                binding.editTextTextPassword.text.clear()
            }
        }
    }
}

