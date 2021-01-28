package com.koba.viewtypemanage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.koba.viewtypemanage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        with(binding){
            buttonBlue.setOnClickListener {
                viewTarget.setBackgroundColor(Color.parseColor("#0011ff"))
            }
            buttonRed.setOnClickListener {
                viewTarget.setBackgroundColor(Color.parseColor("#ff0000"))
            }
            buttonYellow.setOnClickListener {
                viewTarget.setBackgroundColor(Color.parseColor("#fffb00"))
            }
        }
    }
}