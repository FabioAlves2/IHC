package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Cacifo1Binding


class Cacifo1Activity : ComponentActivity() {

    private lateinit var binding: Cacifo1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Cacifo1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cacifo1.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo2.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo3.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo4.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo5.setOnClickListener {
            val intent = Intent(this@Cacifo1Activity, Cacifo2Activity::class.java)
            intent.putExtra("num", binding.cacifo5.text.toString())
            startActivity(intent)
        }
        binding.cacifo6.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo7.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo8.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo9.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo10.setOnClickListener {
            val intent = Intent(this@Cacifo1Activity, Cacifo2Activity::class.java)
            intent.putExtra("num", binding.cacifo10.text.toString())
            startActivity(intent)
        }
        binding.cacifo11.setOnClickListener {
            Toast.makeText(this@Cacifo1Activity, "Este cacifo não está disponível", Toast.LENGTH_SHORT).show()
        }
        binding.cacifo12.setOnClickListener {
            val intent = Intent(this@Cacifo1Activity, Cacifo2Activity::class.java)
            intent.putExtra("num", binding.cacifo12.text.toString())
            startActivity(intent)
        }
        binding.back.setOnClickListener{
            val intent = Intent(this@Cacifo1Activity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Cacifo1Activity, AccountActivity::class.java)
            startActivity(intent)
        }


    }
}