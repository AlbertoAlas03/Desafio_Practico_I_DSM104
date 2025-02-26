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
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class Ejercicio2Activity : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var salario:EditText
    private lateinit var button: Button
    private lateinit var resultadoSalario: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        fun Double.redondear(): Double{
            return "%.2f".format(this).toDouble()
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)
        nombre = findViewById(R.id.nombreSalrio)
        salario = findViewById(R.id.salario)
        button = findViewById(R.id.btn_salario)
        resultadoSalario = findViewById(R.id.resultadoSalrio)
        button.setOnClickListener{
            val nom = nombre.text.toString()
            val sal = salario.text.toString().toDoubleOrNull()
            if(nom == "" || sal == null ){
                Toast.makeText(this, "Error, debe completar todos los campos correctamente.", Toast.LENGTH_SHORT).show()
            }else {
                val afp = (sal * 0.0725).redondear()
                val isss = (sal * 0.03).redondear()
                var renta = 0.toDouble()
                //validar renta
                if(sal>472.00 || sal<=895.24){
                    renta= (17.67+ (sal-472.00)*0.1).redondear()
                }else if(sal>895.24 || sal<=2038.10){
                    renta= (60.00+ (sal-895.24)*0.2).redondear()
                }else if(sal>2038.10){
                    renta= (288.57+ (sal-2038.10)*0.3).redondear()
                }
                val salarioNeto =(sal-renta-afp-isss).redondear()
                resultadoSalario.text="El salario de $nom es:$$sal \n" +
                        "El AFP descontado es :$$afp \n"+
                        "El ISSS descontado es :$$isss \n"+
                        "La renta descontada es :$$renta \n"+
                        "El salrio neto es :$$salarioNeto \n"
            }
        }
    }
}