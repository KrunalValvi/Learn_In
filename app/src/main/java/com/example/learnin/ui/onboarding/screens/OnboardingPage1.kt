package com.example.learnin.ui.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnin.R
import androidx.navigation.NavController
import com.example.learnin.ui.theme.LearnInTheme

@Composable
fun Onboarding1(navController: NavController) {
    LearnInTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFDEE9FF),
                            Color(0xFFFFFFFF)
                        )
                    )
                )
        ) {
            // Center the Image
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.onboarding1),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(300.dp)
                )
                Spacer(modifier = Modifier.height(300.dp))
            }

            // Align the Card to the Bottom Center
            Card(
                shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "Education is the best\nlearn ever",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "It is a long established fact that a reader will be\n distracted by the readable content of a page \nwhen looking at its layout.",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(25.dp)
                                .size(12.dp)
                                .background(Color(0xFF335EEA), CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(Color.LightGray, CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(Color.LightGray, CircleShape)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Skip",
                            color = Color.Gray,
                            style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.clickable {
                                navController.navigate("LoginScreen")
                            }
                        )

                        Button(
                            onClick = {
                                navController.navigate("onboarding2") // Navigate to Onboarding2 when Next is clicked
                            },
                            colors = ButtonDefaults.buttonColors(Color(0xFF335EEA)),
                            shape = MaterialTheme.shapes.small
                        ) {
                            Text(
                                text = "Next",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Onboarding1Preview() {
    Onboarding1(navController = NavController(context = LocalContext.current))
}