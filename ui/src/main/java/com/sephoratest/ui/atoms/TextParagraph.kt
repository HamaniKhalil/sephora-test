package com.sephoratest.ui.atoms

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TextParagraph(
    text: String = "Paragraph",
    color: Color = Color.Black,
    fontSize: Int = 16,
    textAlign: TextAlign = TextAlign.Start,
    overflow: TextOverflow = TextOverflow.Visible,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Medium,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
    )
}
