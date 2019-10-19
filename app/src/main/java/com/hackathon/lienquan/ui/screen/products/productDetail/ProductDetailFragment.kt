package com.hackathon.lienquan.ui.screen.products.productDetail

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.databinding.FragmentProductDetailBinding
import com.hackathon.lienquan.ui.base.BaseFragment
import com.hackathon.lienquan.ui.screen.cart.CartFragment
import kotlinx.android.synthetic.main.fragment_product_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailFragment : BaseFragment<FragmentProductDetailBinding, ProductDetailViewModel>() {
    override val viewModel: ProductDetailViewModel by viewModel()
    override val layoutId: Int = com.hackathon.lienquan.R.layout.fragment_product_detail

    companion object {
        const val PRODUCT = "PRODUCT"
        const val TAG = "ProductDetailFragment"
        fun newInstance(product: Product) = ProductDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(PRODUCT, product)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product: Product? = arguments?.getParcelable(PRODUCT)
        viewModel.product.value = product

        btn_back.setOnClickListener {
            activity!!.onBackPressed()
        }

        btn_cart.setOnClickListener {
            replaceFragment(CartFragment.newInstance(), CartFragment.TAG, true)
        }

        btn_buy_now.setOnClickListener {
            AlertDialog.Builder(context)
                .setMessage("Sản phẩm đã được thêm vào giỏ hàng")
                .setPositiveButton(
                    "Xem Giỏ Hàng"
                ) { _, _ ->
                    replaceFragment(CartFragment.newInstance(), CartFragment.TAG, true)
                }
                .show()
        }
    }
}