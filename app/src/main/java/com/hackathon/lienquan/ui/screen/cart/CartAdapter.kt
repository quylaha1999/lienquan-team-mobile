package com.hackathon.lienquan.ui.screen.cart

import androidx.recyclerview.widget.DiffUtil
import com.hackathon.lienquan.R
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.databinding.ItemCartBinding
import com.hackathon.lienquan.ui.base.BaseRecyclerAdapter

class CartAdapter() :
    BaseRecyclerAdapter<Product, ItemCartBinding>(object :
        DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.title == newItem.title
                    && oldItem.img == newItem.img
        }
    }) {

    override fun getLayoutRes(viewType: Int) = R.layout.item_cart

    override fun bindFirstTime(binding: ItemCartBinding) {
        binding.apply {
            root.setOnClickListener {
                item?.apply {

                }
            }
        }
    }
}