package com.example.learnin.ui.auth.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SignUpScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
//                .background(Color(0xFFEFEFFE))
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(200.dp))

            Text(
                text = "Sign Up",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()
            )

            Row {
                Text(
                    text = "By Signing up, your agree to our ! ",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = "Terms",
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.clickable { }
                )
                Text(
                    text = " And ",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = "privacy policy.",
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.clickable { }
                )
            }

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Full Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Phone Number") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                )
            )

            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Email Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                )
            )

            Button(
                onClick = {
                    navController.navigate("OtpScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(text = "Register", color = Color.White)
            }

                Text(
                    text = "Already have account ! ",
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = "Login",
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.clickable{navController.navigate("LoginScreen")}
                )
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(navController = NavController(context = LocalContext.current))
}