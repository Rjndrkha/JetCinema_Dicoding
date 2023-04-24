package com.dicoding.rajendra.jettixid.ui.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dicoding.rajendra.jettixid.R
import com.dicoding.rajendra.jettixid.ui.components.ProfilePage

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier

) {

   ProfilePage(
       profileImage = "https://media.licdn.com/dms/image/D5603AQEwhBWyu7eEIg/profile-displayphoto-shrink_200_200/0/1677775757572?e=1687996800&v=beta&t=BzCgv1riK7LcmNM3hZZjlU8n9BfYyK5lZYb66lf_Z1g" ,
       name = "Rajendra Rakha",
       email = "Rajendra.rakha29@gmail.com",
       onBackClick = {}
   )


}