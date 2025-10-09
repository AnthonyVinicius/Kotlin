package br.com.ifpe.livedata.ui.viewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.ifpe.livedata.R
import br.com.ifpe.livedata.databinding.ActivityMainBinding
import br.com.ifpe.livedata.ui.UiStateUser
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel.usuario.observe(this) { usuario ->
//            usuario?.let {
//                binding.textView.text = "nome: ${it.nome}"
//                binding.textView2.text = "idade: ${it.idade}"
//            }
//        }
//        viewModel.carregarUsuario()
        lifecycleScope.launch {
            viewModel.uiStateUser.collectLatest { stateUser ->
                when(stateUser){
                    is UiStateUser.Loading -> {
                        binding.textView.text = "Carregando"
                        binding.textView2.text = ""
                    }
                    is UiStateUser.Sucess -> {
                        binding.textView.text =
                            getString(R.string.lbl_name, stateUser.user.nome)
                            getString(R.string.lbl_idade, stateUser.user.idade)
                    }
                    is UiStateUser.Error -> {
                        binding.textView.text = "Erro: ${stateUser.msg}"
                        binding.textView2.text = ""
                    }
                }

            }
        }
    }
}