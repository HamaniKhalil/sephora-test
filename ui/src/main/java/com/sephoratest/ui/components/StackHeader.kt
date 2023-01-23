package com.sephoratest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sephoratest.ui.R
import com.sephoratest.ui.atoms.TextTitle

@Preview
@Composable
fun StackHeader(
    modifier: Modifier = Modifier,
    title: String = "Title",
    onBackClicked: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterStart),
            onClick = onBackClicked
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_left),
                contentDescription = stringResource(id = R.string.accessibility_back),
                tint = Color.Black,
            )
        }

        TextTitle(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .align(Alignment.Center),
            text = title,
            textAlign = TextAlign.Center,
        )
    }
}