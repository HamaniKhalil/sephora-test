package com.sephoratest.ui.atoms

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriceValue(
    modifier: Modifier = Modifier,
    price: Double,
    color: Color = Color.Black,
    fontSize: Int = 18,
) {
    val parts = price.toString().split(".")
    Row(
        modifier = modifier,
    ) {
        Text(
            text = parts[0],
            color = color,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
        )
        Box {
            Text(
                modifier = Modifier
                    .align(Alignment.TopStart),
                text = String.format("%02d", parts[1].toInt()),
                color = color,
                fontSize = 8.sp,
            )
        }
        Spacer(modifier = Modifier.size(3.dp))
        Text(
            text = "€",
            color = color,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
