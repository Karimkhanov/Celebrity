package com.example.celebritylab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.celebritylab2.databinding.ItemCelBinding
import com.example.celebritylab2.model.entity.Celebrity

class CelebrityListAdapter :
    ListAdapter<Celebrity, CelebrityListAdapter.ViewHolder>(CelebrityDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(celebrity: Celebrity) {
            with(binding) {
                celName.text = celebrity.name
                celGender.text = celebrity.gender
                celNationality.text = celebrity.nationality
                celOccupation.text = celebrity.occupation?.joinToString(", ")
                celBirthday.text = celebrity.birthday
                celAge.text = celebrity.age.toString()



            }
        }
    }

}
