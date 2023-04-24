package com.dicoding.rajendra.jettixid.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ccom.dicoding.rajendra.jettixid.ui.components.CartItem
import coil.compose.rememberImagePainter
import com.dicoding.rajendra.jettixid.R
import com.dicoding.rajendra.jettixid.ui.theme.JetTixIdTheme

@Composable
fun ProfilePage(
    profileImage: String,
    name: String,
    email: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//        ) {
//            Image(
//                painter = rememberImagePainter(data = profileImage),
//                contentDescription = null,
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(1f)
//                    .clip(RoundedCornerShape(bottomEnd = 40.dp))
//            )
//            Icon(
//                imageVector = Icons.Default.ArrowBack,
//                contentDescription = stringResource(R.string.back),
//                modifier = Modifier
//                    .padding(16.dp)
//                    .clickable { onBackClick() }
//                    .background(Color.White, CircleShape)
//            )
//        }

        Image(
            painter = rememberImagePainter(data = profileImage),
            contentDescription = "Profile Image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp))
        )

        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = name,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = email,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePreview() {
    JetTixIdTheme {
        ProfilePage(
            profileImage = "https://media.licdn.com/dms/image/D5603AQEwhBWyu7eEIg/profile-displayphoto-shrink_200_200/0/1677775757572?e=1687996800&v=beta&t=BzCgv1riK7LcmNM3hZZjlU8n9BfYyK5lZYb66lf_Z1g",
            name = "Rajendra Rakha",
            email = "Rajendra.rakha29@gmail.com",
            onBackClick = {},
        )
    }
}