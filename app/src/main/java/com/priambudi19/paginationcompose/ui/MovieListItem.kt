package com.priambudi19.paginationcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.priambudi19.paginationcompose.data.model.Movie


@Composable
fun Poster(posterPath: String, modifier: Modifier) {
    Image(
        painter = rememberImagePainter(
            data = "https://image.tmdb.org/t/p/w185/$posterPath",
            builder = {
                transformations(
                    RoundedCornersTransformation(8f))
            }),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth(), elevation = 10.dp
    ) {
        Box {
            Row(modifier = Modifier.align(Center)) {
                Spacer(modifier = Modifier.width(4.dp))
                Poster(
                    posterPath = movie.posterPath,
                    modifier = Modifier
                        .height(110.dp)
                        .width(90.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Column {
                    Text(
                        text = movie.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(text = movie.releaseDate)
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }

    }
}

