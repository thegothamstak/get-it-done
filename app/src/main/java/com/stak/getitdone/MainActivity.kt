package com.stak.getitdone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.tabs.TabLayoutMediator
import com.stak.getitdone.data.GetItDoneDatabase
import com.stak.getitdone.data.Task
import com.stak.getitdone.data.TaskDao
import com.stak.getitdone.databinding.ActivityMainBinding
import com.stak.getitdone.databinding.DialogAddTaskBinding
import java.util.concurrent.Executors
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: GetItDoneDatabase
    private val taskDao: TaskDao by lazy {
        database.getTaskDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = PagerAdapter(this)
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = "Tasks"
        }.attach()

        binding.fab.setOnClickListener { showAddTaskDialog() }

        database = GetItDoneDatabase.createDatabase(this)
        val taskDao = database.getTaskDao()

        //  Traditional approach
//        val runnable = Runnable {
//            taskDao.createTask(Task(title = "test task 1"))
//
//            taskDao.getAllTasks()
//        }
//
//        Thread(runnable).start()

        //  For Java
//        Executors.newSingleThreadExecutor().execute {
//            taskDao.createTask(Task(title = "test task 1"))
//            taskDao.getAllTasks()
//        }

        //  For kotlin
        thread {
            taskDao.createTask(Task(title = "test task 1"))
            taskDao.getAllTasks()
        }
    }

    private fun showAddTaskDialog() {
        val dialogBinding = DialogAddTaskBinding.inflate(layoutInflater)

    //  Material dialog builder implementation
//        MaterialAlertDialogBuilder(this)
//            .setTitle("Add new task")
//            .setView(dialogBinding.root)
//            .setPositiveButton("Save") { _, _ ->
//
//            }
//            .setNegativeButton("Cancel", null)
//            .show()

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(dialogBinding.root)
        dialog.show()
    }

    inner class PagerAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount() = 1

        override fun createFragment(position: Int): Fragment {
            return TasksFragment()
        }

    }
}