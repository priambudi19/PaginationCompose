package com.priambudi19.paginationcompose.data.remote

import com.priambudi19.paginationcompose.data.model.TmdbListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular?api_key=${MovieApiClient.API_KEY}")
    suspend fun getListMovie(@Query("page") page: Int) : Response<TmdbListResponse>
}