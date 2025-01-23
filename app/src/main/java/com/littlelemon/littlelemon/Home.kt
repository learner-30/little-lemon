package com.littlelemon.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

//@Preview(showBackground = true)
@Composable
fun Home(navController: NavHostController, databaseMenuItems: List<MenuItemRoom>) {
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
        Column (
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(color = LittleLemonColor.green)
        ) {
            Text(
                text = "Little Lemon",
                modifier = Modifier.padding(start = 15.dp),
                color = LittleLemonColor.yellow,
                fontSize = 64.sp,
                fontFamily = FontFamily(Font(R.font.markazitext_variablefont_wght, FontWeight.Medium))
            )
            Row {
                Column() {
                    Text(
                        text = "Chicago",
                        modifier = Modifier.padding(start = 15.dp),
                        color = LittleLemonColor.cloud,
                        fontSize = 40.sp,
                        fontFamily = FontFamily(Font(R.font.markazitext_variablefont_wght, FontWeight.Normal))
                    )
                    Text(
                        text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                        modifier = Modifier.width(240.dp).padding(start = 15.dp, top = 5.dp),
                        color = LittleLemonColor.cloud,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.karla_variablefont_wght, FontWeight.Medium))
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.hero_image),
                    contentDescription = "hero image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .size(width = 140.dp, height = 170.dp)
                )
            }
        }
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(color = Color.Gray)
        ) {  }
        MenuItems(databaseMenuItems)
    }
}

//@Preview(showBackground = true)
@Composable
fun MenuItems(databaseMenuItems: List<MenuItemRoom>) {
    val menuItems = databaseMenuItems

    LazyColumn () {
        items(
            items = menuItems,
            itemContent = { menu -> MenuItem(menu.title, menu.description, menu.price, menu.image) }
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuItem(title: String, description: String, price: String, image: String) {
    Row(
        modifier = Modifier.padding(start = 15.dp).height(140.dp).fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.width(280.dp),
        ) {
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = title,
                color = LittleLemonColor.charcoal,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.karla_variablefont_wght, FontWeight.Bold))
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = description,
                color = LittleLemonColor.charcoal,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.karla_variablefont_wght, FontWeight.Normal)),
                minLines = 4
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            Text(
                text = "$%.2f".format(price.toDouble()),
                color = LittleLemonColor.charcoal,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.karla_variablefont_wght, FontWeight.Medium)),
            )
        }
        GlideImage(
            model = convertUrl(image),
            contentDescription = title,
            modifier = Modifier.padding(top = 20.dp).size(100.dp),
            contentScale = ContentScale.Crop,
        )
    }
    HorizontalDivider(
        thickness = 1.dp,
        color = Color.Gray
    )
}

fun convertUrl(githubUrl: String): String {
    val convertedUrl = if (githubUrl.contains("github.com")) {
        githubUrl.replace("github.com", "raw.githubusercontent.com").replace("/blob", "")
    } else {
        githubUrl
    }

    return convertedUrl
}