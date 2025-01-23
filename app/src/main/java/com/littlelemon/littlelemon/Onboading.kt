package com.littlelemon.littlelemon

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor


@Preview(showBackground = true)
@Composable
fun OnBoarding() {
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier.padding(vertical = 20.dp).height(40.dp),
                contentScale = ContentScale.FillHeight
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LittleLemonColor.green),
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            Text(
                text = "Let's get to know you",
                modifier = Modifier.padding(vertical = 40.dp),
                color = LittleLemonColor.cloud,
                fontSize = 24.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = "Personal information",
                modifier = Modifier.padding(start = 15.dp, top = 40.dp, bottom = 25.dp),
                color = LittleLemonColor.charcoal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        UserInput("First name")
        UserInput("Last name")
        UserInput("Email")

        Box(
            modifier = Modifier.fillMaxSize().padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(LittleLemonColor.yellow),
                border = BorderStroke(width = 1.dp, color = Color.Yellow)
            ) {
                Text(
                    text = "Register",
                    color = LittleLemonColor.charcoal,
                    fontSize = 16.sp
                )
            }
        }
    }
}


@Composable
fun UserInput(item: String) {
    Column(
        modifier = Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp)
    ) {
        var inputText by remember { mutableStateOf("") }

        Text(text = item, fontSize = 14.sp)
        Spacer(modifier = Modifier.padding(top = 5.dp))
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 18.sp),
            shape = RoundedCornerShape(10.dp)
        )
    }
}
