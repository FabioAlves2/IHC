package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Livro2Binding

class Livro2Activity : ComponentActivity() {

    private lateinit var binding: Livro2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Livro2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.autor.text = "Autor: Fernão Lopes"
        binding.nome.text = "Nome: Memorias"
        binding.data.text = "Data: 1826"

        binding.autor2.text = "Autor: José Saramago"
        binding.nome2.text = "Nome: Memorial do Convento"
        binding.data2.text = "Data: 1982"

        binding.clickable.setOnClickListener{
            val intent = Intent(this@Livro2Activity, Livro3Activity::class.java)
            intent.putExtra("Autor", "Fernão Lopes")
            intent.putExtra("Nome", "Memorias")
            intent.putExtra("Data", "1826")
            startActivity(intent)
        }
        binding.clickable2.setOnClickListener{
            Toast.makeText(this@Livro2Activity, "Este livro não se encontra disponível", Toast.LENGTH_SHORT).show()
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Livro2Activity, Livro1Activity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Livro2Activity, AccountActivity::class.java)
            startActivity(intent)
        }


    }

}