package br.com.ifpe.livedata.ui.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.ifpe.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.usuario.observe(this) { usuario ->
            usuario?.let {
                binding.textView.text = "nome: ${it.nome}"
                binding.textView2.text = "idade: ${it.idade}"
            }
        }
        viewModel.carregarUsuario()
    }
}