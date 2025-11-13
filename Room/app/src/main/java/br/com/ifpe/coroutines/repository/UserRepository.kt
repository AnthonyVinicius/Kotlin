package br.com.ifpe.coroutines.repository

import br.com.ifpe.coroutines.dao.UserDao
import br.com.ifpe.coroutines.models.User
import br.com.ifpe.coroutines.service.UserService

class UserRepository (private var userDao : UserDao,
                      private val userService : UserService
){

    suspend fun getUsers(forceRefresh : Boolean = false) : List<User>{
       val localData = userDao.getAll()
        return if(localData.isNotEmpty() && forceRefresh) {
            val remoteData = userService.fecthUsers()
            userDao.insertAll(remoteData)
            remoteData
        } else {
            localData
        }
    }
}