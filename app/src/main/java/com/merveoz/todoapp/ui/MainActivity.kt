package com.merveoz.todoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.merveoz.todoapp.common.viewBinding
import com.merveoz.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //activity içindeki elementlere id'leri ile erişme izni
        //yukarıda tanımlanan değişkenin rootunu veriyoruz:
        setContentView(binding.root)
    }
}