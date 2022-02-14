package com.priambudi19.paginationcompose.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.priambudi19.paginationcompose.data.model.Movie
import com.priambudi19.paginationcompose.data.remote.MovieApiService
import retrofit2.HttpException
import java.io.IOException

class TmdbPagingSource(private val movieApiService: MovieApiService) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val nextPage = params.key ?: 1
        return try {
            val response = movieApiService.getListMovie(nextPage).body()!!
            LoadResult.Page(
                data = response.results,
                prevKey = if (response.page > 1) response.page - 1 else null,
                nextKey = if (response.results.isEmpty()) null else response.page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}