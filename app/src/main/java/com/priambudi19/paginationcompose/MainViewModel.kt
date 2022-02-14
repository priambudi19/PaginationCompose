package com.priambudi19.paginationcompose

import androidx.lifecycle.ViewModel
import com.priambudi19.paginationcompose.data.repo.MovieRepository
import com.priambudi19.paginationcompose.data.repo.MovieRepositoryImpl

class MainViewModel : ViewModel() {
    private val repo : MovieRepository = MovieRepositoryImpl()
    fun getListMovie() = repo.getListMovie()
}