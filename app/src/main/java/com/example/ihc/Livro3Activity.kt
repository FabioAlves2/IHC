package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Livro3Binding

class Livro3Activity : ComponentActivity() {

    private lateinit var binding: Livro3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Livro3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val dados = intent.extras
        val nome = dados?.getString("Nome")
        val autor = dados?.getString("Autor")
        val data = dados?.getString("Data")

        //dados da base de dados, hardcoded de momento
        val piso = "3"
        val estante = "12"
        val prateleira = "512.2"

        val mensagem = "O livro $nome de $data do autor $autor encontra-se disponível no:"
        binding.textView.text = mensagem
        val mensagem2 = "Piso: $piso \n Estante: $estante\n Prateleira: $prateleira"
        binding.textView2.text = mensagem2

        binding.reservar.setOnClickListener {
            Toast.makeText(this@Livro3Activity, "Processo em desenvolvimento", Toast.LENGTH_SHORT).show()
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Livro3Activity, Livro1Activity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Livro3Activity, AccountActivity::class.java)
            startActivity(intent)
        }
        binding.voltar.setOnClickListener {
            val intent = Intent(this@Livro3Activity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}