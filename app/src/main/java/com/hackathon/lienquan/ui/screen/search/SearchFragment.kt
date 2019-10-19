package com.hackathon.lienquan.ui.screen.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.hackathon.lienquan.R
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.databinding.FragmentSearchBinding
import com.hackathon.lienquan.ui.base.BaseFragment
import com.hackathon.lienquan.ui.screen.products.productDetail.ProductDetailFragment
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(),
    View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.button_clear_search -> text_search.setText("")
            R.id.button_back -> activity?.onBackPressed()
        }
    }

    override val viewModel: SearchViewModel by viewModel()
    override val layoutId = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        registerEvents()
        handleData()
    }

    private fun registerEvents() {
        button_clear_search.setOnClickListener(this)
        button_back.setOnClickListener(this)
    }

    private fun handleData() {
        val adapter = SearchAdapter(itemClickListener = { toDetailProduct(it) })
        viewModel.searchProductList.observe(this, Observer {
            adapter.submitList(it)
        })
        recycler_product.adapter = adapter
    }

    private fun toDetailProduct(product: Product) {
        replaceFragmentInSearch(
            ProductDetailFragment.newInstance(product),
            ProductDetailFragment.TAG, true
        )
    }

    companion object {
        const val TAG = "SearchFragment"
        fun newInstance() = SearchFragment()
    }
}
