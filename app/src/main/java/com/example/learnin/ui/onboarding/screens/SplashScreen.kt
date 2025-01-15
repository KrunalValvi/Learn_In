package com.example.learnin.ui.onboarding.screens

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Function to create a Card with elevation
@Composable
fun ElevationCard(title: String, elevation: Dp, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(elevation),
        modifier = modifier.size(100.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = title,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(8.dp)
            )
        }
    }
}

// Function to create a row of elevation cards
@Composable
fun ElevationRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ElevationCard("Elevation - 1", elevation = 2.dp)
        ElevationCard("Elevation - 2", elevation = 4.dp)
        ElevationCard("Elevation - 3", elevation = 8.dp)
        ElevationCard("Elevation - 4", elevation = 16.dp)
    }
}

// Function to create a complete Elevation demo
@Composable
fun ElevationDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Elevation_ Drop Shadow", style = MaterialTheme.typography.titleMedium)
        ElevationRow()
    }
}

@Preview(showBackground = true)
@Composable
fun TestTypographyPreview() {
    ElevationDemo()
}