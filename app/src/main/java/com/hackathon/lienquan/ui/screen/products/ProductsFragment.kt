package com.hackathon.lienquan.ui.screen.products

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hackathon.lienquan.data.Category
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.databinding.FragmentProductsBinding
import com.hackathon.lienquan.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_products.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductsFragment : BaseFragment<FragmentProductsBinding, ProductsViewModel>() {
    override val viewModel: ProductsViewModel by viewModel()
    override val layoutId: Int = com.hackathon.lienquan.R.layout.fragment_products
    val adapter = ProductsAdapter(itemClickListener = { goToDetail(it) })

    companion object {
        const val CATEGORY = "CATEGORY"
        const val TAG = "ProductsFragment"

        fun newInstance(category: Category) = ProductsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY, category)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view_products.adapter = this.adapter

        val category: Category? = arguments?.getParcelable(CATEGORY)
        toolbar.title = category?.title
        viewModel.apply {
            products.observe(viewLifecycleOwner, Observer {
                adapter?.submitList(it)
            })
            getProductsByIdCategory(category?.id)
        }

        toolbar.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                activity!!.onBackPressed()
            }
        })
    }


    private fun goToDetail(product: Product?) {

    }
}
