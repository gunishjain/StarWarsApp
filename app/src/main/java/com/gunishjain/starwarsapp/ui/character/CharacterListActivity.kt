package com.gunishjain.starwarsapp.ui.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gunishjain.starwarsapp.databinding.ActivityMainBinding

class CharacterListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}