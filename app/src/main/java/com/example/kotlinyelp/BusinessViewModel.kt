package com.example.kotlinyelp

import androidx.lifecycle.ViewModel
import com.example.kotlinyelp.data.BusinessRepository

class BusinessViewModel(private val businessRepository: BusinessRepository) : ViewModel() {
    fun getBusiness(pos: Int) = businessRepository.getBusiness(pos)
    fun getBusinesses(term: String = "") = businessRepository.getBusinesses(term)
}
