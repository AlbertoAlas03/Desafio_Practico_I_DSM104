package com.example.pantallaprincipal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio1Activity : AppCompatActivity() {
    //para crear variables de datos
    private lateinit var nombre:EditText
    private lateinit var nota1:EditText
    private lateinit var nota2:EditText
    private lateinit var nota3:EditText
    private lateinit var nota4:EditText
    private lateinit var nota5:EditText
    private lateinit var button:Button
    private lateinit var resultado:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //referenciando
        nombre = findViewById(R.id.nombre)
        nota1 = findViewById(R.id.nota1)
        nota2 = findViewById(R.id.nota2)
        nota3 = findViewById(R.id.nota3)
        nota4 = findViewById(R.id.nota4)
        nota5 = findViewById(R.id.nota5)
        button = findViewById(R.id.btn_promedio)
        resultado = findViewById(R.id.resultado)
        button.setOnClickListener{
            //capturando datos
            val name = nombre.text.toString()
            val n1 = nota1.text.toString().toDoubleOrNull()
            val n2 = nota2.text.toString().toDoubleOrNull()
            val n3 = nota3.text.toString().toDoubleOrNull()
            val n4 = nota4.text.toString().toDoubleOrNull()
            val n5 = nota5.text.toString().toDoubleOrNull()
            //validacion por si los campos son vacios
            if(name == "" || n1 == null ||  n2 == null ||  n3 == null ||  n4 == null ||  n5 == null){
                Toast.makeText(this, "Error, debe completar todos los campos correctamente.", Toast.LENGTH_SHORT).show()
            }else{
                //validacion de rango [0-10]
                if(n1 < 0 || n1 > 10 || n2 < 0 || n2 > 10 || n3 < 0 || n3 > 10 || n4 < 0 || n4 > 10 || n5 < 0 || n5 > 10){
Toast.makeText(this, "Error, revise los campos ingresados, todos los campos tienen que estar en el rango [0-10]", Toast.LENGTH_SHORT).show()
                }else{
                    //calculo nota
                    val p1 = n1*0.15
                    val p2 = n2*0.15
                    val p3 = n3*0.20
                    val p4 = n4*0.25
                    val p5 = n5*0.25
                    val promedioAns = p1+p2+p3+p4+p5
                    if(promedioAns >= 6){
                        resultado.text = "El promedio de $name es: $promedioAns \n" +
                                "Aprobado"
                    }else{
                        resultado.text = "El promedio de $name es: $promedioAns \n" +
                                "Reprobado"
                    }
                }
            }
        }

    }
}