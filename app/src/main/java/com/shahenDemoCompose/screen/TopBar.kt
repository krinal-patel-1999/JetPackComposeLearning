package com.shahenDemoCompose.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun TopBar(
    onBackPress: () -> Unit = {},
    showBackArrow: Boolean = false,
    navigationIcon: ImageVector = Icons.Outlined.LocationOn,
    showTitle: Boolean = false,
    title: String = "Title",
    showFilter: Boolean = false,

) {
    TopAppBar(title = {
        Box(modifier = Modifier.fillMaxWidth()) {

            if (showBackArrow) {
                Image(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(12.dp)
                        .clickable {
                            onBackPress()
                        },
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }

            if (showTitle) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(12.dp),
                    text = title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            if (showFilter) {
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp),
                    imageVector = Icons.Filled.FilterAlt,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Color.White)
                )
            }
        }
    },colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorResource(id = R.color.darkBlue)))
}