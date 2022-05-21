package com.example.a11_nlivedata.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.a11_nlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myMainViewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            //click
            button.setOnClickListener {
                myMainViewModel.siteName.value = "https://mortezza.ir"
            }

            //Get Data
                //check ui
            val siteInfo = Observer<String>(){
                textView.text = it
            }

                //connection view model-livedata
            myMainViewModel.siteName.observe(this@MainActivity,siteInfo)
        }
    }
}