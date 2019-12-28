package com.yasiralijaved.theplaceholders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.Spacing
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.yasiralijaved.core.data.domain.DomainUser
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : AppCompatActivity() {
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this).get(UsersViewModel::class.java)

        viewModel.users.observe(this, Observer {
            setContent {
                MainScreen(it)
            }
        })
    }
}

@Composable
fun MainScreen(users: List<DomainUser>) {
    MaterialTheme {
        VerticalScroller() {
            Column {
                users.forEach { user ->
                    UserRowWidget(user.name, user.email)
                }
            }
        }

    }
}
@Composable
fun UserRowWidget(name: String, email: String) {
    Column(modifier = Spacing(16.dp)) {
        Text(text = name)
        Text(text = email)
    }
}


@Preview
@Composable
fun DefaultPreview() {
    val data = mutableListOf(
        DomainUser(id = 0,
            name = "Name",
            username = "username",
            email = "email",
            phone = "phone"))
    MainScreen(data)
}
