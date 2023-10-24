package com.example.questiongame


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SecondScreen(

    navController: NavController
) {

    Button(onClick = { navController.navigate(route = Screen.Home.route) }) {
        Icon(
            Icons.Default.Home,
            contentDescription = null
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .offset(y = (150).dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            text = "Askers!",
            color = Color.Red,
            fontSize = 85.sp,
            fontWeight = FontWeight.Bold
        )

        Button(modifier = Modifier
                .offset(y = (350).dp),
                onClick = {
                navController.navigate(route = Screen.Category.route)
            }) {
            Text(
                text = "Jugar",
                color = Color.White,
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SecondSceenPreview() {
    SecondScreen(
        navController = rememberNavController()
    )
}