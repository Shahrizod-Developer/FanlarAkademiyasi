package com.example.fanlarakademiyasi.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fanlarakademiyasi.data.model.ChildCategory
import com.example.fanlarakademiyasi.databinding.ItemCategoryBinding
import com.example.fanlarakademiyasi.databinding.ItemChildCategoryBinding


class ChildCategoryAdepter : ListAdapter<ChildCategory, ChildCategoryAdepter.ViewHolder>(
    IntroDiffUtilCallBack
) {

    private var onClickItem: ((ChildCategory) -> Unit)? = null

    fun onClickItem(block: (ChildCategory) -> Unit) {
        onClickItem = block
    }

    inner class ViewHolder(private val binding: ItemChildCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onClickItem?.invoke(getItem(absoluteAdapterPosition))
            }
        }

        fun onBind() {
            binding.title.text = getItem(absoluteAdapterPosition).title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChildCategoryBinding.inflate(
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

private val IntroDiffUtilCallBack = object : DiffUtil.ItemCallback<ChildCategory>() {

    override fun areItemsTheSame(
        oldItem: ChildCategory,
        newItem: ChildCategory
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: ChildCategory,
        newItem: ChildCategory
    ): Boolean {
        return oldItem.id == newItem.id
                && oldItem.title == newItem.title
                && oldItem.code == newItem.code
                && oldItem.categoryCode == newItem.categoryCode
    }

}