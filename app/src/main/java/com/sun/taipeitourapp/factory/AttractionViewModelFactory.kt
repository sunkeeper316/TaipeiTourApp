package com.sun.taipeitourapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sun.taipeitourapp.model.repository.AttractionListDataRepository
import com.sun.taipeitourapp.viewmodel.AttractionViewModel

class AttractionViewModelFactory(private var attractionListRepository: AttractionListDataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AttractionViewModel::class.java)) {
            return AttractionViewModel(attractionListRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}