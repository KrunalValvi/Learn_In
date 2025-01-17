package com.example.learnin.ui.auth.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learnin.R

@Composable
fun CongratulationsScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            // Back Icon
//            Icon(
//                painter = painterResource(id = R.drawable.ic_back_arrow),
//                contentDescription = "Back",
//                modifier = Modifier
//                    .align(Alignment.Start)
//                    .clickable { /* Handle back navigation */ }
//            )

            Spacer(modifier = Modifier.height(16.dp))

            // Success Icon
            Box{
                Icon(
                    painter = painterResource(id = R.drawable.ic_checkmark),
                    contentDescription = "Success",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Title
            Text(
                text = "Congratulations!",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Green
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = "Your account has been registered",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Action Button
            Button(
                onClick = {
                    navController.navigate("HomeScreen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF556EFF))
            ) {
                Text(text = "Go to Home", style = MaterialTheme.typography.bodyLarge, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CongratulationsScreenPreview() {
    CongratulationsScreen(navController = NavController(context = LocalContext.current))
}