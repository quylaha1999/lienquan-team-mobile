package com.hackathon.lienquan.ui.screen.search

import androidx.recyclerview.widget.DiffUtil
import com.hackathon.lienquan.R
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.databinding.ItemProductBinding
import com.hackathon.lienquan.ui.base.BaseRecyclerAdapter

class SearchAdapter(val itemClickListener: (Product) -> Unit = {}) :
    BaseRecyclerAdapter<Product, ItemProductBinding>(object :
        DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }) {
    override fun getLayoutRes(viewType: Int) = R.layout.item_product

    override fun bindFirstTime(binding: ItemProductBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {
                    itemClickListener(this)
                }
            }
        }
    }
}