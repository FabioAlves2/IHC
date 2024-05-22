package com.example.ihc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.MapaBinding

class MapaActivity : ComponentActivity() {

    private lateinit var binding: MapaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MapaBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.back.setOnClickListener {
            val intent = Intent(this@MapaActivity, Livro3Activity::class.java)
            intent.putExtra("Livro", "Livro1")
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener {
            val intent = Intent(this@MapaActivity, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.voltar.setOnClickListener {
            val intent = Intent(this@MapaActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}