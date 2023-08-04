package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaração de variáveis do ViewGroup
        val btnCalculate:Button = findViewById(R.id.btnCalculate)
        val edtWeight:EditText = findViewById(R.id.edtTxtWeight)
        val edtHeight:EditText = findViewById(R.id.edtTxtHeight)

        //Ação do botão
        btnCalculate.setOnClickListener {
            //Declaração de variaveis altura e peso
            val heightStr:String = edtHeight.text.toString()
            val weightStr:String = edtWeight.text.toString()
            //Tratamento de erro
            if(heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                //Declaração de variaveis que serao usadas no calculo do imc
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()
                val finalHeight: Float = height * height
                val result = weight / finalHeight

                //Intent para a transição de tela
                val intent = Intent(this, resultActivity::class.java)
                    //Chave de recuperação do resultado
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }
        }

    }
}