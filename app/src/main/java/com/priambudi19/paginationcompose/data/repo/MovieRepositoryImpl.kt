package com.priambudi19.paginationcompose.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.priambudi19.paginationcompose.data.model.Movie
import com.priambudi19.paginationcompose.data.remote.MovieApiClient
import com.priambudi19.paginationcompose.paging.TmdbPagingSource
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl : MovieRepository {
    private val movieApiService = MovieApiClient.getInstance()
    override fun getListMovie(): Flow<PagingData<Movie>> {
        val pagingSourceFactory = { TmdbPagingSource(movieApiService) }
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                prefetchDistance = 20
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

}