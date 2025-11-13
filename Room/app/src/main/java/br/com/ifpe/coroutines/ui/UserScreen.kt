package br.com.ifpe.coroutines.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.ifpe.coroutines.models.User
import br.com.ifpe.coroutines.viewmodel.UserViewModel

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {

    val users by viewModel.users.observeAsState(initial = emptyList<User>())

    Column {
        Button(onClick = { viewModel.loadUsers() }) {
            Text(text = "Carregar Usuários")
        }

        LazyColumn {
            items(users) { user ->
                Text(text = user.firstName)
            }
        }
    }
}
