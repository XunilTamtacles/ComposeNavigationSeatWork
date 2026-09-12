package com.example.composenavigationseatwork

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onViewDetails: (String, String, String, String) -> Unit
) {
    var studentId by remember { mutableStateOf("23-0612-671") }
    var studentName by remember { mutableStateOf("Matt Linux B. Bondoc") }
    var studentCourse by remember { mutableStateOf("Computer Engineering") }
    var studentYear by remember { mutableStateOf("4") }

    var loginAttempts by remember { mutableStateOf(0) }

    var errorMessage by remember { mutableStateOf("") }
    var showConfirmDialog by remember { mutableStateOf(false) }

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
                OutlinedTextField(
                    value = studentId,
                    onValueChange = { studentId = it },
                    label = { Text("Student ID") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = studentName,
                    onValueChange = { studentName = it },
                    label = { Text("Name") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )

                OutlinedTextField(
                    value = studentCourse,
                    onValueChange = { studentCourse = it },
                    label = { Text("Course") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )

                OutlinedTextField(
                    value = studentYear,
                    onValueChange = { studentYear = it },
                    label = { Text("Year") },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
            }
        }

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color(0xFFC62828),
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Text(
            text = "Login Attempts: $loginAttempts",
            color = Color(0xFF1565C0),
            modifier = Modifier.padding(top = 16.dp)
        )

        Button(
            onClick = { loginAttempts++ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add Attempt")
        }

        Button(
            onClick = {
                studentId = ""
                studentName = ""
                studentCourse = ""
                studentYear = ""
                loginAttempts = 0
                errorMessage = ""
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF757575)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Clear")
        }

        Button(
            onClick = {
                if (studentId.isEmpty()) {
                    errorMessage = "Student ID is required."
                } else if (studentName.isEmpty()) {
                    errorMessage = "Name is required."
                } else if (studentCourse.isEmpty()) {
                    errorMessage = "Course is required."
                } else {
                    errorMessage = ""
                    showConfirmDialog = true
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("View Details")
        }
    }

    if (showConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmDialog = false },
            title = { Text("Confirm Student Information") },
            text = { Text("View details for:\n$studentName?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showConfirmDialog = false
                        onViewDetails(studentId, studentName, studentCourse, studentYear)
                    }
                ) {
                    Text("Continue")
                }
            },
            dismissButton = {
                TextButton(onClick = { showConfirmDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}