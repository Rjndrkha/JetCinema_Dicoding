package ccom.dicoding.rajendra.jettixid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dicoding.rajendra.jettixid.ui.components.ProductCounter
import com.dicoding.rajendra.jettixid.ui.theme.JetTixIdTheme
import com.dicoding.rajendra.jettixid.ui.theme.Shapes
import com.dicoding.rajendra.jettixid.R

@Composable
fun CartItem(
    rewardId: Long,
    posterUrl: String,
    title: String,
    totalPoint: Int,
    count: Int,
    year: String,
    duration: String,
    requiredPoint: Int,
    synopsis: String,

    onProductCountChanged: (id: Long, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val painter = rememberImagePainter(
        data = posterUrl,
        builder = {
            crossfade(true)
        }
    )

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(90.dp)
                .clip(Shapes.small)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1.0f)
        ) {
            Text(
                text = title,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = stringResource(
                    R.string.required_point,
                    totalPoint
                ),
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.subtitle2,
            )
        }
        ProductCounter(
            orderId = rewardId,
            orderCount = count,
            onProductIncreased = { onProductCountChanged(rewardId, count + 1) },
            onProductDecreased = { onProductCountChanged(rewardId, count - 1) },
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CartItemPreview() {
    JetTixIdTheme {
        CartItem(
            1,
            "https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg",
            "Avengers: Endgame",
            2000,
            1,
            "2013",
            "3h 1min",
            3000,
            "asd",
            onProductCountChanged = { rewardId, count -> },
        )
    }
}