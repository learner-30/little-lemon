package com.littlelemon.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

//@Preview(showBackground = true)
@Composable
fun Home(navController: NavHostController) {
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .size(width = 200.dp, height = 40.dp)
                    .align(alignment = Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.padding(end = 30.dp))
            IconButton(
                onClick = {
                    navController.navigate(Profile.route)
                },
                modifier = Modifier
                    .size(width = 60.dp, height = 60.dp)
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Profile",
                    )
            }
            Spacer(modifier = Modifier.padding(end = 20.dp))
        }
    }
}