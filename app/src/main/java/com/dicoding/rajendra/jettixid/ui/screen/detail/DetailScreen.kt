package com.dicoding.rajendra.jettixid.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.dicoding.rajendra.jettixid.R
import com.dicoding.rajendra.jettixid.di.Injection
import com.dicoding.rajendra.jettixid.ui.ViewModelFactory
import com.dicoding.rajendra.jettixid.ui.common.UiState
import com.dicoding.rajendra.jettixid.ui.components.OrderButton
import com.dicoding.rajendra.jettixid.ui.components.ProductCounter
import com.dicoding.rajendra.jettixid.ui.theme.JetTixIdTheme


@Composable
fun DetailScreen(
    rewardId: Long,
    viewModel: DetailRewardViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navigateBack: () -> Unit,
    navigateToCart: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getRewardById(rewardId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.movie.requiredPoint,
                    data.count,
                    posterUrl = data.movie.posterUrl,
                    title = data.movie.title,
                    year = data.movie.year,
                    duration = data.movie.duration,
                    requiredPoint = data.movie.requiredPoint,
                    synopsis = data.movie.synopsis,


                    onBackClick = navigateBack,
                    onAddToCart = { count ->
                        viewModel.addToCart(data.movie, count)
                        navigateToCart()
                    }
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    basePoint: Int,
    count: Int,
    posterUrl: String,
    title: String,
    year: String,
    duration: String,
    requiredPoint: Int,
    synopsis: String,

    onBackClick: () -> Unit,
    onAddToCart: (count: Int) -> Unit,

    modifier: Modifier = Modifier,
) {
    val painter = rememberImagePainter(
        data = posterUrl,
        builder = {
            crossfade(true)
        }
    )

    var totalPoint by rememberSaveable { mutableStateOf(0) }
    var orderCount by rememberSaveable { mutableStateOf(count) }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.back),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { onBackClick() }
                    .background(Color.White, CircleShape)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.required_point, basePoint),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                color = MaterialTheme.colors.secondary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = synopsis,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Justify,
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(LightGray)
        )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = year,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = duration,
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ProductCounter(
                1,
                orderCount,
                onProductIncreased = { orderCount++ },
                onProductDecreased = { if (orderCount > 0) orderCount-- },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            totalPoint = basePoint * orderCount
            OrderButton(
                text = stringResource(R.string.add_to_cart, totalPoint),
                enabled = orderCount > 0,
                onClick = {
                    onAddToCart(orderCount)
                }
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    JetTixIdTheme {
        DetailContent(
            3000,
            2,
            "https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg",
            "Avengers: Endgame",
            "2013",
            "3h 1min",
            3000,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins.",
            onBackClick = {},
            onAddToCart = {}
        )
    }
}