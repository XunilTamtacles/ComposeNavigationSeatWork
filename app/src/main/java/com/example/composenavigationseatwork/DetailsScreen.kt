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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(
    studentId: String,
    studentName: String,
    studentCourse: String,
    studentYear: String,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Student Details", color = Color(0xFF2E7D32))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .border(1.dp, Color(0xFFA5D6A7), shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Column {
                Text(text = "Student ID: $studentId")
                Text(text = "Name: $studentName")
                Text(text = "Course: $studentCourse")
                Text(text = "Year: $studentYear")
            }
        }

        Button(
            onClick = { onBack() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Edit Information")
        }

        Button(
            onClick = { onBack() },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Back")
        }
    }
}