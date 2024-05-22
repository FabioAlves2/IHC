package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.HomeBinding


class HomeActivity : ComponentActivity() {
    private lateinit var binding: HomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Botão do perfil
        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        //Botão reservar sala
        binding.sala.setOnClickListener{
            val intent = Intent(this@HomeActivity, ReservaActivity::class.java)
            startActivity(intent)
        }

        binding.cacifo.setOnClickListener {
            val intent = Intent(this@HomeActivity, Cacifo1Activity::class.java)
            startActivity(intent)
        }

        binding.livro.setOnClickListener {
            val intent = Intent(this@HomeActivity, Livro1Activity::class.java)
            startActivity(intent)
        }
        binding.helpdesk.setOnClickListener {
            Toast.makeText(this@HomeActivity, "Processo em desenvolvimento", Toast.LENGTH_SHORT).show()
        }
    }
}