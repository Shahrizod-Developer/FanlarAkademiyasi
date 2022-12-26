package com.example.fanlarakademiyasi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.data.model.IntroData
import com.example.fanlarakademiyasi.databinding.ItemCategoryBinding
import com.example.fanlarakademiyasi.databinding.ItemIntroBinding


class CategoryAdepter : ListAdapter<List<ChildCategory>, CategoryAdepter.ViewHolder>(
    IntroDiffUtilCallBack
) {
    inner class ViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
//            binding.rv.adapter =
//            binding.text.text = getItem(absoluteAdapterPosition).text
//            binding.image.setImageResource(getItem(absoluteAdapterPosition).image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
}

private val IntroDiffUtilCallBack = object : DiffUtil.ItemCallback<List<ChildCategory>>() {

    override fun areItemsTheSame(
        oldItem: List<ChildCategory>,
        newItem: List<ChildCategory>
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: List<ChildCategory>,
        newItem: List<ChildCategory>
    ): Boolean {
        return oldItem == newItem
    }

}