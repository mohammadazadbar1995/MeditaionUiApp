package com.example.bottommenu.privew_provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.designsystem.R
import com.example.menu.BottomMenuContent

class BottomMenuContentProvider : PreviewParameterProvider<BottomMenuContent> {
    override val values: Sequence<BottomMenuContent> = sequenceOf(
        BottomMenuContent(
            title = "Home",
            iconId = R.drawable.ic_home
        ),
        BottomMenuContent(
            title = "Meditate",
            iconId = R.drawable.ic_bubble
        ),
        BottomMenuContent(
            title = "Sleep",
            iconId = R.drawable.ic_moon
        ),
        BottomMenuContent(
            title = "Music",
            iconId = R.drawable.ic_music
        ),
        BottomMenuContent(
            title = "Profile",
            iconId = R.drawable.ic_profile
        )
    )

}