package com.example.weatherappcompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CardHeader(
    modifier: Modifier = Modifier,
    cardType: CardType
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = cardType.icon), contentDescription = "HeaderIcon"
        )
        Text(
            text = stringResource(id = cardType.title),
            style = MaterialTheme.typography.bodySmall)
    }
}

@Preview
@Composable
fun CardHeaderPreview() {
    CardHeader(cardType = CardType.HOURLY)
}