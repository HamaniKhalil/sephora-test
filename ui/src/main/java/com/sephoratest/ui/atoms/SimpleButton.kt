package com.sephoratest.ui.atoms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SimpleButton(
    modifier: Modifier = Modifier,
    text: String = "Ok",
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults
            .buttonColors(
                backgroundColor = Color.Black,
                contentColor = Color.White,
            ),
        elevation = ButtonDefaults
            .elevation(10.dp),
    ) {
        Text(text = text)
    }
}