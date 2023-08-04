package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult:TextView = findViewById(R.id.textview_result)
        val tvClassificacao:TextView = findViewById(R.id.textview_Classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if(result < 18.5f){
            "Abaixo do peso"
        }else if(result < 24.9f){
            "Normal"
        }else if(result < 29.9f){
            "Sobrepeso"
        }else if(result < 39.9f){
            "Obesidade"
        }else{
            "Obesidade Grave"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}