package com.littlelemon.littlelemon

import android.app.AlertDialog
import android.content.SharedPreferences
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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

//@Preview(showBackground = true)
@Composable
fun OnBoarding(navController: NavHostController, builder: AlertDialog.Builder, sharedPreferences: SharedPreferences) {
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
        var firstName by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp)
        ) {
            Text(text = "First name", fontSize = 14.sp)
            Spacer(modifier = Modifier.padding(top = 5.dp))
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                shape = RoundedCornerShape(10.dp)
            )
        }

        var lastName by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp)
        ) {
            Text(text = "Last name", fontSize = 14.sp)
            Spacer(modifier = Modifier.padding(top = 5.dp))
            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                shape = RoundedCornerShape(10.dp)
            )
        }

        var email by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.padding(top = 30.dp, start = 15.dp, end = 15.dp)
        ) {
            Text(text = "Email", fontSize = 14.sp)
            Spacer(modifier = Modifier.padding(top = 5.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(fontSize = 18.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                shape = RoundedCornerShape(10.dp)
            )
        }

        Box(
            modifier = Modifier.fillMaxSize().padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = {
                    if (!firstName.isBlank() && !lastName.isBlank() && !email.isBlank())
                    {
                        builder.setMessage("Registration successful!").show()
                        sharedPreferences.edit().putBoolean("IsUserLoggedIn", true).apply()
                        navController.navigate(Home.route)
                    } else {
                        builder.setMessage("Registration unsuccessful.Please enter all data.").show()
                    }
                },
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
