package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Cacifo2Binding


class Cacifo2Activity : ComponentActivity() {

    private lateinit var binding: Cacifo2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Cacifo2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dados = intent.extras
        val num = dados?.getString("num")

        val mensagem = "Selecione um horário para alugar o cacifo número $num"
        binding.modificar.text=mensagem

        //Configuração escolha de horas de inicio
        val hours = resources.getStringArray(R.array.hours)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,hours)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        //Configuração escolha de horas de termino
        val hours2 = resources.getStringArray(R.array.hours2)
        val adapter2 = ArrayAdapter(this,android.R.layout.simple_spinner_item,hours2)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter = adapter2


        //butao de confirmar
        binding.confirmar.setOnClickListener {
            val selecteditem = binding.spinner.selectedItemPosition
            val selecteditem2 = binding.spinner2.selectedItemPosition
            if (selecteditem>selecteditem2){
                Toast.makeText(this@Cacifo2Activity,"Redifina o horário", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this@Cacifo2Activity, Cacifo3Activity::class.java)
                intent.putExtra("horas",hours[selecteditem])
                intent.putExtra("horas2",hours2[selecteditem2])
                intent.putExtra("num",num)
                startActivity(intent)
            }
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Cacifo2Activity, Cacifo1Activity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Cacifo2Activity, AccountActivity::class.java)
            startActivity(intent)
        }


    }
}