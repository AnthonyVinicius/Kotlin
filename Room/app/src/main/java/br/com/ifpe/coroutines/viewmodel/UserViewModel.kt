package br.com.ifpe.coroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ifpe.coroutines.models.User
import br.com.ifpe.coroutines.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    fun loadUsers(forceRefresh: Boolean = false) {
        viewModelScope.launch {
            val data = userRepository.getUsers(forceRefresh)
            _users.postValue(data)
        }
    }
}
