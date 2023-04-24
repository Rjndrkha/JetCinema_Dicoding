package com.dicoding.rajendra.jettixid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.dicoding.rajendra.jettixid.R
import com.dicoding.rajendra.jettixid.ui.theme.JetTixIdTheme
import com.dicoding.rajendra.jettixid.ui.theme.Shapes

@Composable
fun RewardItem(
    posterUrl: String,
    title: String,
    year: String,
    duration: String,
    requiredPoint: Int,
    synopsis: String,

    modifier: Modifier = Modifier,
) {
    val painter = rememberImagePainter(
        data = posterUrl,
        builder = {
            crossfade(true)
        }

    )
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 5.dp, end = 5.dp),
        elevation = 8.dp
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(Shapes.medium)
                    .border(2.dp, MaterialTheme.colors.primary, Shapes.medium)
            )

            Spacer(Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = synopsis,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = year,
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                    )

                    Spacer(Modifier.width(4.dp))

                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = "10/10",
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                    )

                    Spacer(Modifier.width(4.dp))

                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(16.dp)
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = duration,
                        style = MaterialTheme.typography.caption,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.6f)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RewardItemPreview() {
    JetTixIdTheme {
        RewardItem(
            "https://lumiere-a.akamaihd.net/v1/images/p_avengersendgame_19751_e14a0104.jpeg",
            "Avengers: Endgame",
            "2013",
            "3h 1min",
            4000,
            "After the devastating events of Avengers: Infinity War, the universe is in ruins.",

        )
    }
}