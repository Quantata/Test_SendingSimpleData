package com.example.connectotherapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.connectotherapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        when (intent?.action) {
            Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    handleSendText(intent)
                }
            }
            else -> {
                handleSendText(intent)
            }
        }
    }

    private fun handleSendText(intent: Intent) {
        binding.tvText.text = intent.getStringExtra(Intent.EXTRA_TEXT) ?: "is NULL!!!"
    }
}