package com.example.currentsection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.ButtonBlue
import com.example.designsystem.theme.LightRed
import com.example.designsystem.theme.TextWhite


@Composable
fun CurrentMediationSection(
    color: Color = LightRed,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Column {
            Text(
                text = "Daily Thought",
                style = MaterialTheme.typography.headlineSmall,
                color = TextWhite
            )

            Text(
                text = "Meditation 3-10 min",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonBlue)
                .size(40.dp)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = com.example.designsystem.R.drawable.ic_play
                ),
                contentDescription = "Play",
                tint = TextWhite,
                modifier = Modifier.size(16.dp)
            )
        }

    }
}