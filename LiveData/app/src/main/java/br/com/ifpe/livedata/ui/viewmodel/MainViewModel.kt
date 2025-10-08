package br.com.ifpe.livedata.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ifpe.livedata.ui.model.User

class MainViewModel : ViewModel(){

    private val _usuario = MutableLiveData<User>()
    val usuario: LiveData<User> get() = _usuario

    fun carregarUsuario(){
        _usuario.value = User("Anthony", 21)
    }
}