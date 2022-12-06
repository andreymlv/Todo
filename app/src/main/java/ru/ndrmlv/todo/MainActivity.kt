package ru.ndrmlv.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.ndrmlv.todo.compose.MainMenu
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
    val tasks = listOf(
        TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root without sub", "test", null
            ), emptyList()
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root", "desc 1", null
            ), listOf(
                Task(
                    remember { mutableStateOf(false) }, "task sub", "desc 2", null
                )
            )
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root without sub", "test", null
            ), emptyList()
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root", "desc 1", null
            ), listOf(
                Task(
                    remember { mutableStateOf(false) }, "task sub", "desc 2", null
                )
            )
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root without sub", "test", null
            ), emptyList()
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root", "desc 1", null
            ), listOf(
                Task(
                    remember { mutableStateOf(false) }, "task sub", "desc 2", null
                )
            )
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root without sub", "test", null
            ), emptyList()
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root", "desc 1", null
            ), listOf(
                Task(
                    remember { mutableStateOf(false) }, "task sub", "desc 2", null
                )
            )
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root without sub", "test", null
            ), emptyList()
        ), TaskGroup(
            Task(
                remember { mutableStateOf(false) }, "task root", "desc 1", null
            ), listOf(
                Task(
                    remember { mutableStateOf(false) }, "task sub", "desc 2", null
                )
            )
        )
    )
    val completedTasks: List<TaskGroup> = listOf(
        TaskGroup(
            Task(
                remember { mutableStateOf(true) }, "task root without sub", "test", null
            ), emptyList()
        )
    )
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        MainMenu(tasks, completedTasks)
    }
}
