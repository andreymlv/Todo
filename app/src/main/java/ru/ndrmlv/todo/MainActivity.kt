package ru.ndrmlv.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
        Column {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
            ) {
                Task(false, "test")
                Task(false, "test")
                Task(false, "test")
                Task(false, "test")
                Task(false, "test")
                Task(true, "test")
                Task(false, "test")
                Task(false, "test")
                Task(true, "test")
                Task(false, "test")
                Task(false, "test")
                Task(false, "test")
                Task(true, "test")
                Task(false, "test")
                Task(false, "test")
                Task(true, "test")
                Task(false, "test")
                Task(false, "test")
                Task(true, "test")
                Task(false, "test")
                Task(false, "test")
                Task(true, "test")
                Task(false, "test")
                Task(false, "test")
            }
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = { /*TODO*/ }, shape = CircleShape, modifier = Modifier.size(48.dp)
                ) {
                    Text(text = "+")
                }
            }
        }
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
