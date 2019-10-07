package com.example.kotlinyelp.util

import com.example.kotlinyelp.BusinessViewModelFactory
import com.example.kotlinyelp.data.BusinessDao
import com.example.kotlinyelp.data.BusinessRepository

object InjectorUtil {
    fun provideBusinessViewModelFactory(): BusinessViewModelFactory {
        val businessRepository = BusinessRepository.getInstance(BusinessDao())
        return BusinessViewModelFactory(businessRepository)
    }
}