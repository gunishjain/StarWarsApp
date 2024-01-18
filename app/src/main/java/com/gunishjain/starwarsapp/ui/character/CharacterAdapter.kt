package com.gunishjain.starwarsapp.ui.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gunishjain.starwarsapp.data.model.Character
import com.gunishjain.starwarsapp.databinding.CharacterItemBinding

class CharacterAdapter:
    PagingDataAdapter<Character,CharacterAdapter.CharacterViewHolder>(COMPARATOR) {

    class CharacterViewHolder(val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) {

            binding.nameTextView.text = character.name
            binding.genderTextView.text = character.gender
            binding.massTextView.text = character.mass
            binding.birthYearTextView.text = character.birth_year

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return  oldItem.name==newItem.name
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem==newItem
            }
        }
    }
}