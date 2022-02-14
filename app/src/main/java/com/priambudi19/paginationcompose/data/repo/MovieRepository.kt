package com.priambudi19.paginationcompose.data.repo

import androidx.paging.PagingData
import com.priambudi19.paginationcompose.data.model.Movie
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun getListMovie() : Flow<PagingData<Movie>>
}