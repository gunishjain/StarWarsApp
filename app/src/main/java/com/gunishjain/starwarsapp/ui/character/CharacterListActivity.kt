package com.gunishjain.starwarsapp.ui.character

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.gunishjain.starwarsapp.StarWarsApplication
import com.gunishjain.starwarsapp.databinding.ActivityMainBinding
import com.gunishjain.starwarsapp.di.component.DaggerActivityComponent
import com.gunishjain.starwarsapp.di.module.ActivityModule
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharacterListActivity : AppCompatActivity() {

    @Inject
    lateinit var characterListViewModel: CharacterListViewModel

    @Inject
    lateinit var characterAdapter: CharacterAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createCharacterListRV()
        setupObserver()
    }

    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as StarWarsApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

    private fun createCharacterListRV() {
        binding.rvCharacter.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = characterAdapter
        }
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                characterListViewModel.uiState.collect {
                    Log.d("Gunish", it.toString())
                    characterAdapter.submitData(it)
                }
            }
        }

    }
}