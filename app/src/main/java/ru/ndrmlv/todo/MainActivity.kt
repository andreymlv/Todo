package ru.ndrmlv.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                FloatingActionButton(onClick = {/* TODO */}) {
                    Text("+")
                }
            },
            content = { paddingValues ->
                LazyColumn(modifier = Modifier.padding(paddingValues)) {
                    items(50) {
                        Task(completed = false, content = "test $it")
                        Task(completed = true, content = "test $it")
                    }
                }
            },
        )
    }
}

@Composable
fun Task(completed: Boolean, content: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(), shape = RoundedCornerShape(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = completed, onCheckedChange = { /*TODO*/ })
            Text(text = content)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    TodoTheme {
        MyApp()
    }
}
