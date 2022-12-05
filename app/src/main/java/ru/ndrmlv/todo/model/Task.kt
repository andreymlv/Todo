package ru.ndrmlv.todo.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import java.util.*

class Task(
    private val completed: Boolean,
    private val task: String,
    private val desc: String?,
    private val alarmedAt: Date?,
    private val createdAt: Date = Date(),
    private val updatedAt: Date = Date(),
    private val uid: UUID = UUID.randomUUID(),
) {
    fun toggle(): Task {
        return Task(!completed, task, desc, alarmedAt, createdAt, Date(), uid)
    }

    fun complete(): Task {
        return Task(true, task, desc, alarmedAt, createdAt, Date(), uid)
    }

    @Composable
    fun View() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = completed, onCheckedChange = { /*TODO*/ })
            Column {
                Text(text = task)
                desc?.also {
                    Text(text = desc, fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}
