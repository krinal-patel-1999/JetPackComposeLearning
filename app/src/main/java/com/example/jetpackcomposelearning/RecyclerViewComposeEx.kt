package com.example.jetpackcomposelearning

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(
)
@Composable
private  fun previewItem() {
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
    ) {
        getCategoryList().map { item ->
            BlogCategory(img = item.img, title = item.title, subTitle = item.subTitle)
        }
    }

   /* LazyColumn(content = {
        items(getCategoryList()){ item ->
            BlogCategory(img = item.img, title = item.title, subTitle = item.subTitle)

        }
    })*/
}

@Composable
fun BlogCategory(img: Int,title:String ,subTitle:String) {
    Card(
        modifier = Modifier.padding(8.dp)


        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            Column(modifier = Modifier.weight(.8f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = subTitle,
                    fontWeight = FontWeight.Thin,
                    fontSize = 12.sp
                )
            }
        }
    }
}

data class CategoryList(val img: Int,val title: String,val subTitle: String)

fun getCategoryList():MutableList<CategoryList>{
    val list = mutableListOf<CategoryList>()
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))
    list.add(CategoryList(R.drawable.baseline_supervised_user_circle_24,"Programing","Learn Different Languages"))

    return list
}






