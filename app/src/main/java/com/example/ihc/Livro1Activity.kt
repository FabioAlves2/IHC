package com.example.ihc

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Livro1Binding

class Livro1Activity : ComponentActivity() {

    private lateinit var binding: Livro1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Livro1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val searchbar = binding.bar.text.toString().trim()

        binding.search.setOnClickListener {
            //aceder a base de dados
            //comparar a searchbar com nome dos titulos e autores


            val intent = Intent(this@Livro1Activity, Livro2Activity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Livro1Activity, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Livro1Activity, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}