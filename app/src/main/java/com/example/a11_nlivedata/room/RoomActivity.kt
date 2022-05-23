package com.example.a11_nlivedata.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.room.Room
import com.example.a11_nlivedata.R
import com.example.a11_nlivedata.databinding.ActivityRoomBinding
import com.example.a11_nlivedata.room.db.NoteDatabase
import com.example.a11_nlivedata.utils.NOTE_DATABASE

class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    val noteDb : NoteDatabase by lazy {
        Room.databaseBuilder(this , NoteDatabase::class.java , NOTE_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navController = findNavController(R.id.fragmentContainerView)
            appBarConfiguration = AppBarConfiguration(navController.graph) //---> روش بهتر.بجای وارد کردن تک تک ای دی ها.فقط بنویسید .graph
            setupActionBarWithNavController(navController,appBarConfiguration)
        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}