package com.example.ihc

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.ihc.databinding.Sala2Binding


class Reserva2Activity :  ComponentActivity() {

    private lateinit var binding: Sala2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Sala2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar dados
        val dados = intent.extras
        val hours1 = dados?.getString("horas")
        val hours2 = dados?.getString("horas2")

        binding.sala1.setOnClickListener {
            Toast.makeText(this@Reserva2Activity, "Sala não disponível no horário selecionado", Toast.LENGTH_SHORT).show()
        }
        binding.sala2.setOnClickListener {
            Toast.makeText(this@Reserva2Activity, "Sala não disponível no horário selecionado", Toast.LENGTH_SHORT).show()
        }
        binding.sala3.setOnClickListener {
            Toast.makeText(this@Reserva2Activity, "Sala não disponível no horário selecionado", Toast.LENGTH_SHORT).show()
        }
        binding.sala4.setOnClickListener {
            val builder = AlertDialog.Builder(this@Reserva2Activity)
            builder.setTitle("Confirmação")
            val mensagem = "Quer mesmo reservar a sala " + binding.sala4.text.toString() + " das " + hours1 + "-" + hours2 + "?"
            builder.setMessage(mensagem)
            builder.setPositiveButton("Sim") { _, _ ->
                val intent = Intent(this@Reserva2Activity, Reserva3Activity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("Cancelar") { _, _ ->

            }
            val dialog = builder.create()
            dialog.show()
        }
        binding.sala5.setOnClickListener {
            val builder = AlertDialog.Builder(this@Reserva2Activity)
            builder.setTitle("Confirmação")
            val mensagem = "Quer mesmo reservar a sala " + binding.sala5.text.toString() + " das " + hours1 + "-" + hours2 + "?"
            builder.setMessage(mensagem)
            builder.setPositiveButton("Sim") { _, _ ->
                val intent = Intent(this@Reserva2Activity, Reserva3Activity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("Cancelar") { _, _ ->

            }
            val dialog = builder.create()
            dialog.show()
        }
        binding.sala6.setOnClickListener {
            Toast.makeText(this@Reserva2Activity, "Sala não disponível no horário selecionado", Toast.LENGTH_SHORT).show()
        }
        binding.sala7.setOnClickListener {
            val builder = AlertDialog.Builder(this@Reserva2Activity)
            builder.setTitle("Confirmação")
            val mensagem = "Quer mesmo reservar a sala " + binding.sala7.text.toString() + " das " + hours1 + "-" + hours2 + "?"
            builder.setMessage(mensagem)
            builder.setPositiveButton("Sim ") { _, _ ->
                val intent = Intent(this@Reserva2Activity, Reserva3Activity::class.java)
                startActivity(intent)
            }
            builder.setNegativeButton("Cancelar") { _, _ ->

            }
            val dialog = builder.create()
            dialog.show()
        }
        binding.sala8.setOnClickListener {
            Toast.makeText(this@Reserva2Activity, "Sala não disponível no horário selecionado", Toast.LENGTH_SHORT).show()
        }

        binding.back.setOnClickListener{
            val intent = Intent(this@Reserva2Activity, ReservaActivity::class.java)
            startActivity(intent)
        }

        binding.settingsCogIcon.setOnClickListener{
            val intent = Intent(this@Reserva2Activity, AccountActivity::class.java)
            startActivity(intent)
        }

    }
}
