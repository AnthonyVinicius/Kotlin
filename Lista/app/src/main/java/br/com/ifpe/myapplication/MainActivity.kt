package br.com.ifpe.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etTaskTitle: EditText
    private lateinit var btnAddTask: Button
    private lateinit var rvTasks: RecyclerView
    private lateinit var adapter: TaskAdapter

    private var taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTaskTitle = findViewById(R.id.etTaskTitle)
        btnAddTask = findViewById(R.id.btnAddTask)
        rvTasks = findViewById(R.id.rvTasks)

        adapter = TaskAdapter(
            onTaskClicked = { task ->
                task.isCompleted = !task.isCompleted
                adapter.submitList(taskList.toList())
            },
            onDeleteClicked = { task ->
                taskList.remove(task)
                adapter.submitList(taskList.toList())
            }
        )

        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = adapter

        btnAddTask.setOnClickListener {
            val title = etTaskTitle.text.toString()
            if (title.isNotBlank()) {
                val newTask = Task(title = title)
                taskList.add(newTask)
                adapter.submitList(taskList.toList())
                etTaskTitle.text.clear()
            }
        }
    }
}
