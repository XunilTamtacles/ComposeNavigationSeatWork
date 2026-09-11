package com.example.composenavigationseatwork

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {

    val loginAttempts = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF2F8))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Student Information", color = Color(0xFF1565C0))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFF90CAF9), shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(text = "Name: Caleb Dela Cruz")
                Text(text = "Course: BS Computer Engineering")
                Text(text = "Year: 4")
            }
        }

        Text(
            text = "Login Attempts: ${loginAttempts.value}",
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(onClick = { loginAttempts.value = loginAttempts.value + 1 }) {
            Text(text = "Add Attempt")
        }

        Button(
            onClick = { navController.navigate("details") },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "View Details")
        }
    }
}