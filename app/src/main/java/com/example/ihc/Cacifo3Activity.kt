package com.example.ihc

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Cacifo3Binding
import kotlin.random.Random

class Cacifo3Activity : ComponentActivity() {

    private lateinit var binding: Cacifo3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Cacifo3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dados = intent.extras
        val num = dados?.getString("num")
        val hours1 = dados?.getString("horas")
        val hours2 = dados?.getString("horas2")

        val mensagem = "O cacifo número $num foi alugado das $hours1 às $hours2"
        binding.textView.text = mensagem

        val codigo=List(6){ Random.nextInt(0,9)}
        val mensagem1 = codigo.joinToString(separator = "")
        binding.textView2.text=mensagem1

    }
}