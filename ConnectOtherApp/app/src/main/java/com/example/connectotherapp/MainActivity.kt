package com.example.connectotherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.connectotherapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTest.setOnClickListener {
            val packageName = "com.example.connectotherapp2"
            val sendIntent = applicationContext.packageManager.getLaunchIntentForPackage(packageName)
            sendIntent?.apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "THis is my text to Send")
                type = "text/plain"
            }
            // chooser 열림
//            val sendIntent: Intent = Intent().apply {
//                action = Intent.ACTION_SEND
//                putExtra(Intent.EXTRA_TEXT, "THis is my text to Send")
//                type = "text/plain"
//            }


            startActivity(sendIntent)
        }

    }
}