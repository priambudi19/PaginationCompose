package com.priambudi19.paginationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.priambudi19.paginationcompose.ui.MovieItem
import com.priambudi19.paginationcompose.ui.theme.PaginationComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaginationComposeTheme {
                val viewModel: MainViewModel = viewModel()
                val listMovie = remember { viewModel.getListMovie() }.collectAsLazyPagingItems()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(
                        content = {
                            items(items = listMovie, key = { movie -> movie.id }) { movie ->
                                movie?.let {
                                    MovieItem(movie = it)
                                }
                            }
                        },
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(all = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    )
                }
            }
        }
    }
}

