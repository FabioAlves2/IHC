package com.example.ihc

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Sala1Binding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ReservaActivity: ComponentActivity() {

    private lateinit var binding: Sala1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Sala1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //configuração navegação dos dias
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)

        binding.dateText.setText(currentDate)

        binding.rightArrowDate.setOnClickListener{
            //falta implementar nao pode ao fim de semana
            val data = binding.dateText.text.toString()
            calendar.time = dateFormat.parse(data)!!
            calendar.add(Calendar.DAY_OF_YEAR, 1)
            val update = dateFormat.format(calendar.time)
            binding.dateText.setText(update)
        }

        binding.leftArrowDate.setOnClickListener{
            val data = binding.dateText.text.toString()
            calendar.time = dateFormat.parse(data)!!
            if (data.equals(currentDate)){
                Toast.makeText(this@ReservaActivity, "Não pode viajar no tempo", Toast.LENGTH_SHORT).show()
            }
            else{
                calendar.add(Calendar.DAY_OF_YEAR, -1)
                val update = dateFormat.format(calendar.time)
                binding.dateText.setText(update)
            }
        }


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
                Toast.makeText(this@ReservaActivity,"redifina o horario", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this@ReservaActivity,"sucesso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@ReservaActivity, Reserva2Activity::class.java)
                intent.putExtra("horas",hours[selecteditem])
                intent.putExtra("horas2",hours2[selecteditem2])
                startActivity(intent)
            }
        }

        //Botão do perfil
        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@ReservaActivity, ProfileActivity::class.java)
            startActivity(intent)
        }

        //botao do home
        binding.homeIcon.setOnClickListener{
            val intent = Intent(this@ReservaActivity, HomeActivity::class.java)
            startActivity(intent)
        }




    }

}