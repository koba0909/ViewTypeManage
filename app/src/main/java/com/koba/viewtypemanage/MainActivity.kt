package com.koba.viewtypemanage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.koba.viewtypemanage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initLiveDataObserve()
    }

    private fun initView() {
        with(binding){
            buttonBlue.setOnClickListener {
                mainViewModel.requestViewColorType("#0011ff")
            }
            buttonRed.setOnClickListener {
                mainViewModel.requestViewColorType("#ff0000")
            }
            buttonYellow.setOnClickListener {
                mainViewModel.requestViewColorType("#fffb00")
            }
        }
    }

    private fun initLiveDataObserve(){
        with(mainViewModel){
            viewColorTypeLiveData.observe(this@MainActivity) { color ->
                binding.viewTarget.setBackgroundColor(Color.parseColor(color))
            }
        }
    }
}