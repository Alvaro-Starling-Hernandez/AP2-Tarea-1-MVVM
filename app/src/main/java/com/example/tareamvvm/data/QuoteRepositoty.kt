package com.example.tareamvvm.data

import com.example.tareamvvm.data.database.dao.QuoteDao
import com.example.tareamvvm.data.database.entities.QuoteEntity
import com.example.tareamvvm.data.model.QuoteModel
import com.example.tareamvvm.data.network.QuoteService
import com.example.tareamvvm.domain.model.Quote
import com.example.tareamvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api : QuoteService,
    private val quoteDao : QuoteDao
){

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response:List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response : List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}