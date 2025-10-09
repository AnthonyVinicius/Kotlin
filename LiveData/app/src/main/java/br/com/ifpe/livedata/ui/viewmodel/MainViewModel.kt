package br.com.ifpe.livedata.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.ifpe.livedata.ui.UiStateUser
import br.com.ifpe.livedata.ui.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel(){

    //private val _usuario = MutableLiveData<User>()
    //val usuario: LiveData<User> get() = _usuario

    private val _uiStateUser =  MutableStateFlow<UiStateUser>(UiStateUser.Loading)
    val uiStateUser: StateFlow<UiStateUser> = _uiStateUser
    fun carregarUsuario(){
       // _usuario.value = User("Anthony", 21)
        val usuario = User("Anthony", 21)
        _uiStateUser.value = UiStateUser.Sucess(usuario)
    }
}