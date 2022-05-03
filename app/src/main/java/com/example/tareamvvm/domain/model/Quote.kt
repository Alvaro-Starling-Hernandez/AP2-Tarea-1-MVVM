package com.example.tareamvvm.domain.model

import com.example.tareamvvm.data.database.entities.QuoteEntity
import com.example.tareamvvm.data.model.QuoteModel

data class Quote (val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)
