package com.example.ihc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Sala3Binding


class Reserva3Activity : ComponentActivity() {

    private lateinit var binding: Sala3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Sala3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Reserva3Activity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.voltar.setOnClickListener {
            val intent = Intent(this@Reserva3Activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}