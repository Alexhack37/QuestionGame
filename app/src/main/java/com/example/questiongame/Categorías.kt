package com.example.questiongame

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.wallet.button.ButtonConstants

@Preview
@Composable
fun CategorySelector(modifier : Modifier = Modifier){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 200.dp)){
            Text("TV",
                    fontSize = 50.sp
            )
            //Spacer(modifier = Modifier.width(8.dp)), HUECO ENTRE ICONO Y TEXTO
            //Icon(imageVector = Icons.Default.Search, contentDescription = null
        }
            Button(onClick = { /*TODO*/ }, Modifier.padding(top = 375.dp)){
                Text("SERIES",
                    fontSize = 50.sp)
            }

        Button(onClick = { /*TODO*/ }, Modifier.padding(top = 550.dp)){
            Text("BOOKS",
                fontSize = 50.sp)
        }
    }


}

