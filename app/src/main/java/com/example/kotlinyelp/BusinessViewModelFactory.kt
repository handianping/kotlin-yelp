package com.example.kotlinyelp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinyelp.data.BusinessRepository

class BusinessViewModelFactory(private val businessRepository: BusinessRepository)
    : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BusinessViewModel(businessRepository) as T
    }
}