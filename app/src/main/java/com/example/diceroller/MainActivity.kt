package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp()
        }
    }
}

@Composable
fun DiceRollerApp() {
    var diceValue by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F5FF)), // Background soft putih
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Gambar dadu
        Image(
            painter = painterResource(id = getDiceImage(diceValue)),
            contentDescription = "Dice Image",
            modifier = Modifier
                .size(140.dp)
                .clickable { diceValue = Random.nextInt(1, 7) } // Bisa di-tap juga
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Teks hasil dadu
        Text(
            text = "Dadu yang keluar berjumlah $diceValue",
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Roll
        Button(
            onClick = { diceValue = Random.nextInt(1, 7) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7)),
            modifier = Modifier
                .shadow(6.dp, RoundedCornerShape(12.dp))
                .padding(8.dp)
        ) {
            Text("Roll", style = MaterialTheme.typography.titleMedium, color = Color.White)
        }
    }
}

// Fungsi untuk mendapatkan gambar dadu sesuai angka
fun getDiceImage(diceValue: Int): Int {
    return when (diceValue) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    DiceRollerApp()
}
