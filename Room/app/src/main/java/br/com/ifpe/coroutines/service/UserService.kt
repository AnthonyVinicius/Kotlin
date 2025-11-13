package br.com.ifpe.coroutines.service

import br.com.ifpe.coroutines.models.User
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun fecthUsers(): List<User>

}