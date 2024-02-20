package com.deepak.jetpack_compose_api.ui.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.deepak.jetpack_compose_api.R
import com.deepak.jetpack_compose_api.data.model.NewsArticle
import com.deepak.jetpack_compose_api.utils.Util.newsInDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(newsArticle: NewsArticle, navigationUpClick: () -> Unit) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(newsArticle.urlToImage)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painter,
                contentDescription = newsArticle.title,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            newsArticle.title?.let {
                Text(text = it, modifier = Modifier.padding(8.dp), fontSize = 20.sp)
            }
            newsArticle.description?.let {
                Text(
                    text = newsArticle.description,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.more_detail),
                style = TextStyle(color = Color.Blue),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable {
                        newsInDetail(context, newsArticle.url)
                    }
            )
        }
    }
}