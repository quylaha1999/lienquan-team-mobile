package com.hackathon.lienquan.ui.screen.home

import androidx.recyclerview.widget.DiffUtil
import com.hackathon.lienquan.R
import com.hackathon.lienquan.data.Category
import com.hackathon.lienquan.databinding.ItemRecyclerCategoryBinding
import com.hackathon.lienquan.ui.base.BaseRecyclerAdapter

class HomeAdapter(val itemClickListener: (Category) -> Unit = {}) :
    BaseRecyclerAdapter<Category, ItemRecyclerCategoryBinding>(object :
        DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun getLayoutRes(viewType: Int) = R.layout.item_recycler_category

    override fun bindFirstTime(binding: ItemRecyclerCategoryBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}