package com.hackathon.lienquan.ui.screen.search

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import com.hackathon.lienquan.data.SearchProductResponse
import com.hackathon.lienquan.data.model.Product
import com.hackathon.lienquan.data.repository.CloudRepository
import com.hackathon.lienquan.ui.base.BaseViewModel
import com.hackathon.lienquan.utils.BaseSchedulerProvider

class SearchViewModel(
    val baseSchedulerProvider: BaseSchedulerProvider,
    val repository: CloudRepository
) : BaseViewModel() {
    val searchProductList = MutableLiveData<List<Product>>()
    val query = MutableLiveData<String>()
    val editorListener = TextView.OnEditorActionListener { v, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            val q = v.text.toString()
            if (!q.isEmpty()) {
                query.value = q
                getSearchResult("$q")
            }
        }
        true
    }

    fun getSearchResult(query: String) {
        repository.getSearchProductResult(query).observeOn(baseSchedulerProvider.ui())
            .subscribeOn(baseSchedulerProvider.io())
            .subscribe({ data ->
                handleData(data)
            })
    }

    private fun handleData(data: SearchProductResponse) {
        searchProductList.value = data.searchProductList
    }
}