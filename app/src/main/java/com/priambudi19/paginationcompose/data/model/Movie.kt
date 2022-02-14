package com.priambudi19.paginationcompose.data.model


import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("poster_path")
    var posterPath: String = "",
    @SerializedName("release_date")
    var releaseDate: String = "",
    @SerializedName("title")
    var title: String = "",

)