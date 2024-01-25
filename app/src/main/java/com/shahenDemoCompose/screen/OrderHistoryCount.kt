package com.shahenDemoCompose.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpackcomposelearning.R
import com.shahenDemoCompose.viewModel.OrderHistoryViewModel

@Composable
fun OrderHistoryCount( section: String){

    val viewModel: OrderHistoryViewModel = hiltViewModel()
    val isLoadingState = viewModel.isLoadingState.collectAsState().value
    if (isLoadingState == true) {

        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Loading....", style = MaterialTheme.typography.titleLarge)

        }

    } else {
        isLoadingState == false
        OrderHistoryCountDesigen(section)


    }





}

@Composable
fun OrderHistoryCountDesigen(
    section: String
) {
    val viewModel: OrderHistoryViewModel = hiltViewModel()
    val orderHistoryCount by viewModel.orderHistoryCountState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            TopBar(
                showTitle = true,
                title = "Direct Orders",
                showBackArrow = true
            )

            orderHistoryCount?.let { response ->
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    items(response.data) { data ->
                        Card(
                            modifier = Modifier
                                .padding(4.dp)
                                .height(106.dp)
                                .width(165.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.White,
                            )
                        ) {

                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                    // .align(Alignment.CenterHorizontally)
                                ) {
                                    Text(
                                        text = data.label,
                                        fontSize = 14.sp,
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight.Normal

                                    )
                                    Text(
                                        text = data.count.toString(),
                                        fontSize = 24.sp,
                                        modifier = Modifier
                                            .padding(top = 8.dp)
                                            .fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        color = colorResource(id = R.color.darkBlue),
                                        fontWeight = FontWeight.SemiBold
                                    )

                                }
                            }
                        }
                    }
                }

            }
        }

        DisposableEffect(key1 = section) {
            viewModel.getOrderHistoryCount(section)
            onDispose { /* cleanup */ }
        }
    }