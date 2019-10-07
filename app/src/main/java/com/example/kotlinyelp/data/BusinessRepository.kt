package com.example.kotlinyelp.data

class BusinessRepository(private val businessDao: BusinessDao) {
    companion object {
        @Volatile private var instance: BusinessRepository? = null
        fun getInstance(businessDao: BusinessDao) =
            instance ?: synchronized(this) {
                instance ?: BusinessRepository(businessDao).also {
                    instance = it
                }
            }
    }

    fun getBusiness(pos: Int) = businessDao.getBusiness(pos)
    fun getBusinesses(term: String) = businessDao.getBusinesses(term)
}