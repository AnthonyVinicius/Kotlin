package br.com.ifpe.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSimularCalculo = findViewById<Button>(R.id.btnSimularCalculo)
        val btnGerarNumero = findViewById<Button>(R.id.btnGerarNumero)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnSimularCalculo.setOnClickListener {
            activityScope.launch {
                txtResultado.text = "Calculando..."
                val resultado = simularCalculoDemorado()
                txtResultado.text = "Resultado do cálculo: $resultado"
            }
        }

        btnGerarNumero.setOnClickListener {
            activityScope.launch {
                txtResultado.text = "Gerando número..."
                val numero = gerarNumeroAleatorio()
                txtResultado.text = "Número gerado: $numero"
            }
        }
    }

    private suspend fun simularCalculoDemorado(): Int {
        delay(2000)
        return (1..100).random()
    }

    private suspend fun gerarNumeroAleatorio(): Int {
        delay(1500)
        return (100..999).random()
    }

    override fun onDestroy() {
        super.onDestroy()
        activityScope.cancel()
    }
}
