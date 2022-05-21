package com.example.a11_nlivedata.network

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.a11_nlivedata.R
import com.example.a11_nlivedata.databinding.ActivityNetworkBinding

class NetworkActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNetworkBinding

    private val checkConnection by lazy { CheckConnection(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            checkConnection.observe(this@NetworkActivity){
                if (it) {
                    imageView.setImageResource(R.drawable.wifi_on)
                    //imageView.setColorFilter(Color.GREEN,PorterDuff.Mode.MULTIPLY)
                    imageView.setColorFilter(ContextCompat.getColor(this@NetworkActivity,R.color.green),PorterDuff.Mode.MULTIPLY)
                    txtNetworkStatus.text = "Connected"
                    txtNetworkStatus.setTextColor(Color.GREEN)
                } else {
                    imageView.setImageResource(R.drawable.wifi_off)
                    //imageView.setColorFilter(Color.RED,PorterDuff.Mode.MULTIPLY)
                    imageView.setColorFilter(ContextCompat.getColor(this@NetworkActivity,R.color.red),PorterDuff.Mode.DARKEN)
                    txtNetworkStatus.text = "DisConnected"
                    txtNetworkStatus.setTextColor(Color.RED)
                }
            }
        }


    }
}