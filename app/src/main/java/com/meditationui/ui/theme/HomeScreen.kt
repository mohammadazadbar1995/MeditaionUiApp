package com.meditationui.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottommenu.component.BottomMenu
import com.example.currentsection.CurrentMediationSection
import com.example.designsystem.preview_provider.ThemePreview
import com.example.designsystem.theme.Beige1
import com.example.designsystem.theme.Beige2
import com.example.designsystem.theme.Beige3
import com.example.designsystem.theme.BlueViolet1
import com.example.designsystem.theme.BlueViolet2
import com.example.designsystem.theme.BlueViolet3
import com.example.designsystem.theme.ButtonBlue
import com.example.designsystem.theme.DarkerButtonBlue
import com.example.designsystem.theme.DeepBlue
import com.example.designsystem.theme.LightGreen1
import com.example.designsystem.theme.LightGreen2
import com.example.designsystem.theme.LightGreen3
import com.example.designsystem.theme.MeditationUiAppTheme
import com.example.designsystem.theme.OrangeYellow1
import com.example.designsystem.theme.OrangeYellow2
import com.example.designsystem.theme.OrangeYellow3
import com.example.designsystem.theme.TextWhite
import com.example.menu.BottomMenuContent
import com.meditationui.Feature
import com.meditationui.standardQuadTo

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize(),
    ) {
        Column {
            GreetingSection()
            ChipSection(
                listOf(
                    "Sweet sleep",
                    "Insomnia",
                    "Depression"
                )
            )
            CurrentMediationSection()

            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        com.example.designsystem.R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        com.example.designsystem.R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        com.example.designsystem.R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        com.example.designsystem.R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }

        BottomMenu(
            list = listOf(
                BottomMenuContent(
                    title = "Home",
                    iconId = com.example.designsystem.R.drawable.ic_home
                ),
                BottomMenuContent(
                    title = "Meditate",
                    iconId = com.example.designsystem.R.drawable.ic_bubble
                ),
                BottomMenuContent(
                    title = "Sleep",
                    iconId = com.example.designsystem.R.drawable.ic_moon
                ),
                BottomMenuContent(
                    title = "Music",
                    iconId = com.example.designsystem.R.drawable.ic_music
                ),
                BottomMenuContent(
                    title = "Profile",
                    iconId = com.example.designsystem.R.drawable.ic_profile
                )
            ), modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingSection(
    name: String = "Mohammad"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "We wish you have a good day!, $name",
                style = MaterialTheme.typography.bodySmall
            )
        }

        Icon(
            painter = painterResource(
                id = com.example.designsystem.R.drawable.ic_search
            ),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun ChipSection(
    chips: List<String>,

    ) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonBlue else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}
/*

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
*/


@Composable
fun FeatureSection(
    features: List<Feature>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()

        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight


        val mediumColorPoint1 = Offset(0f, height * 0.3f)
        val mediumColorPoint2 = Offset(width * 0.1f, height * 0.5f)
        val mediumColorPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColorPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColorPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColorPoint1.x, mediumColorPoint1.y)
            standardQuadTo(mediumColorPoint1, mediumColorPoint2)
            standardQuadTo(mediumColorPoint2, mediumColorPoint3)
            standardQuadTo(mediumColorPoint3, mediumColorPoint4)
            standardQuadTo(mediumColorPoint4, mediumColorPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadTo(lightPoint1, lightPoint2)
            standardQuadTo(lightPoint2, lightPoint3)
            standardQuadTo(lightPoint3, lightPoint4)
            standardQuadTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                color = TextWhite,
                modifier = Modifier.align(Alignment.TopStart)
            )

            Icon(
                painter = painterResource(
                    id = feature.iconId
                ),
                contentDescription = feature.title,
                tint = TextWhite,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(24.dp)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable {
                        //Handle the click
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(horizontal = 15.dp, vertical = 6.dp)
            )
        }
    }
}


/*
@Composable
fun BottomMenu(
    list: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0,
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp),
    ) {
        list.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    selectedItemIndex = index
                }
            )
        }
    }
}
*/


/*@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                onItemClick()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(
                    if (isSelected) activeHighlightColor else Color.Transparent
                )
                .padding(10.dp)
        ) {

            Icon(
                painter = painterResource(
                    id = item.iconId
                ),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )

            Text(
                text = item.title,
                color = if (isSelected) activeTextColor else inactiveTextColor,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}*/

@ThemePreview
@Composable
fun HomeScreenPreview() {
    MeditationUiAppTheme {
        HomeScreen()
    }
}