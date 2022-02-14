package com.priambudi19.paginationcompose.data.model


import com.google.gson.annotations.SerializedName

data class TmdbListResponse(
    @SerializedName("page")
    var page: Int = 1,
    @SerializedName("results")
    var results: List<Movie> = listOf(),
    @SerializedName("total_pages")
    var totalPages: Int = 0,
    @SerializedName("total_results")
    var totalResults: Int = 0
)