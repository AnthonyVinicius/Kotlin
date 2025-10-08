package br.com.ifpe.livedata.ui

import br.com.ifpe.livedata.ui.model.User

sealed class UiStateUser {

    object Loading: UiStateUser()
    data class Sucess(val user : User) : UiStateUser()
    data class  Error(val msg : String) : UiStateUser()
}