package com.example.pantallaprincipal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var go_ejercicio1:Button
    private lateinit var go_ejercicio2:Button
    private lateinit var go_ejercicio3:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        go_ejercicio1=findViewById(R.id.button)
        go_ejercicio2=findViewById(R.id.button2)
        go_ejercicio3=findViewById(R.id.button3)
        go_ejercicio1.setOnClickListener{
            val intent=Intent(this,Ejercicio1Activity::class.java)
            startActivity(intent)
        }
        go_ejercicio2.setOnClickListener{
            val intent=Intent(this,Ejercicio2Activity::class.java)
            startActivity(intent)
        }
        go_ejercicio3.setOnClickListener{
            val intent=Intent(this,Ejercicio3Activity::class.java)
            startActivity(intent)
        }
    }
}