package ru.ndrmlv.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.ndrmlv.todo.model.Task
import ru.ndrmlv.todo.model.TaskGroup
import ru.ndrmlv.todo.ui.theme.TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    // A surface container using the 'background' color from the theme
    val tasks = listOf(
        TaskGroup(
            Task(
                false, "task", null, null
            ), emptyList()
        ), TaskGroup(
            Task(
                false, "task", "desc", null
            ), listOf(
                Task(
                    false, "task", "desc", null
                )
            )
        )
    )
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("todo") },
                )
            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(onClick = {/* TODO */ }) {
                    Text("+")
                }
            },
            content = { paddingValues ->
                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    // Uncompleted with subtasks offset
                    items(tasks) { task ->
                        task.View(8.dp)
                    }
                    // Completed flat without damn offset
                    items(tasks) { task ->
                        task.complete().View()
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TodoTheme {
        MyApp()
    }
}
