package com.hackathon.lienquan.ui.screen.cart

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.hackathon.lienquan.R
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.databinding.FragmentCartBinding
import com.hackathon.lienquan.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cart.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : BaseFragment<FragmentCartBinding, CartViewModel>() {
    override val viewModel: CartViewModel by viewModel()
    override val layoutId: Int = R.layout.fragment_cart
    val adapter = CartAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view_cart.adapter = adapter
        viewModel.apply {
            products.observe(viewLifecycleOwner, Observer {
                adapter.submitList(it)
            })
            getProduct()
        }
        toolbar.setNavigationOnClickListener { activity!!.onBackPressed() }
    }

    companion object {
        const val TAG = "ProductDetailFragment"
        fun newInstance() = CartFragment()
    }
}