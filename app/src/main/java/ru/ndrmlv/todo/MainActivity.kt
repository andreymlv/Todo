package ru.ndrmlv.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
    val foldCompleted = remember {
        mutableStateOf(true)
    }
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
                        task.View(32.dp)
                    }
                    // Completed flat without damn offset
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(16.dp)
                        ) {
                            Row {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(24.dp)
                                        .clickable(onClick = {
                                            foldCompleted.value = !foldCompleted.value
                                        })
                                ) {
                                    Column {
                                        Text(text = "Completed (number of completed tasks)")
                                    }
                                    Column(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalAlignment = Alignment.End
                                    ) {
                                        if (!foldCompleted.value) {
                                            Text(text = "^")
                                        } else {
                                            Text(text = "v")
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!foldCompleted.value) {
                        items(tasks) { task ->
                            task.complete().View()
                        }
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
