package com.koba.viewtypemanage

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.observe
import com.koba.viewtypemanage.data.ColorType
import com.koba.viewtypemanage.data.MainResult
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
            buttonRed.setOnClickListener {
                mainViewModel.requestViewColorType(ColorType.RED)
            }
            buttonBlue.setOnClickListener {
                mainViewModel.requestViewColorType(ColorType.BLUE)
            }
            buttonYellow.setOnClickListener {
                mainViewModel.requestViewColorType(ColorType.YELLOW)
            }
        }
    }

    private fun initLiveDataObserve(){
        with(mainViewModel){
            stateLiveData.observe(this@MainActivity) {
                when(it) {
                    is MainResult.Success -> {
                        binding.viewTarget.setBackgroundColor(Color.parseColor(it.data.colorCode))
                    }
                    is MainResult.Error -> {
                        println("Error : ${it.exception}")
                    }
                    is MainResult.InProgress -> {
                        println("In progress")
                    }
                }
            }
        }
    }
}