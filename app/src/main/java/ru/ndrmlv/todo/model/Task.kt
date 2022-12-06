package ru.ndrmlv.todo.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import java.util.*

class Task(
    var completed: MutableState<Boolean>,
    private val task: String,
    private val desc: String?,
    private val alarmedAt: Date?,
    private val createdAt: Date = Date(),
    private val updatedAt: Date = Date(),
    private val uid: UUID = UUID.randomUUID(),
) {
    private fun toggle(): Task {
        return Task(mutableStateOf(!completed.value), task, desc, alarmedAt, createdAt, Date(), uid)
    }

    fun complete(): Task {
        return Task(mutableStateOf(true), task, desc, alarmedAt, createdAt, Date(), uid)
    }

    @Composable
    fun View() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = completed.value,
                onCheckedChange = { completed.value = toggle().completed.value })
            Column {
                Text(text = task)
                desc?.also {
                    Text(text = desc, fontSize = 12.sp, color = Color.Gray)
                }
            }
        }
    }
}
