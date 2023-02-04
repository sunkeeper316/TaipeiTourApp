package com.sun.taipeitourapp.viewmodel

import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sun.taipeitourapp.model.AttractionListData
import com.sun.taipeitourapp.model.repository.AttractionListDataRepository

class AttractionViewModel(var attractionListRepository: AttractionListDataRepository)  : ViewModel() {
    var isLoad = false
    fun attractionListModel(categoryIds: String, nlat: Double, elong: Double, page: Int, observer: Observer<AttractionListData>)  {
        if (!isLoad) {
            isLoad = true
            attractionListRepository.getAttractionList(categoryIds , nlat , elong,1) { throwable, response ->
                isLoad = false
                throwable?.let {
                    Log.e("attractionListModel", "items size ${it.printStackTrace()}")
                    return@getAttractionList
                }
                response?.let {

                    observer.onChanged(it.body())
                }
            }
        }
    }
}