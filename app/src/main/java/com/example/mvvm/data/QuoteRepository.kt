package com.example.mvvm.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {
    //mediator between db and the viewmodels

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes() //will return the livedat


    companion object {
        @Volatile
        private var instance: QuoteRepository? = null

        var quoteDao = FakeQuoteDao()
            private set

        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(this) {
            instance ?: QuoteRepository(quoteDao).also { instance = it }
        }

    }
}
