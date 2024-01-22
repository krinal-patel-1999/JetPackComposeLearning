
package com.example.jetpackcomposelearning

import android.graphics.fonts.FontStyle
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.ui.theme.JetPackComposeLearningTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // Text(text = "Hello")
            //TextField()
           // SimpleText()
           // ListCategory()
           // SideEffect()
            LunchEffectComposable()
        }

    }
}


@Preview
@Composable
fun CorutineScopeComposable(){
   val counter = remember {
       mutableStateOf(0)
   }
    var scope = rememberCoroutineScope()

    var text = "counter is runing ${counter.value}"
    if (counter.value == 10){
        text = "Counter Stoped"
    }

    Column() {

        Text(text = text)
        Button(onClick = { scope.launch {
            Log.d("LauncheEffectComposable","started...")
            try {
                for (i in 1..10){
                    counter.value++
                    delay(1000)
                }
            }catch(e:Exception){
                Log.d("LauncheEffectComposable","Exception")
            }}}) {
            Text(text = "Start")
        }
    }
}


@Preview
@Composable
fun LunchEffectComposable(){
    val counter = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit){
        Log.d("LauncheEffectComposable","started...")
        try {
            for (i in 1..10){
                counter.value++
                delay(1000)
            }
        }catch(e:Exception){
            Log.d("LauncheEffectComposable","Exception")
        }
    }

    var text = "Counter is runing ${counter.value}"
    if (counter.value == 10){
        text = "Countr Stoped"
    }
    Text(text = text)

}
//This code for SideEffect

@Preview
@Composable
fun SideEffect(){
   var count = remember {
       mutableStateOf(0)
   }
    LaunchedEffect(key1 = false){
        Log.d("counter","count : ${count.value}")
    }

    Button(onClick = { count.value++ }) {
        Text(text = "Increment")
    }
}

@Preview
@Composable
fun ListCategory(){
    val categoryState = remember {
        mutableStateOf(emptyList<String>())
    }
    LaunchedEffect(key1 = Unit ){
        categoryState.value = fetchCategories()
    }


    LazyColumn{
        items(categoryState.value){ item ->
            Text(text = item)
        }
    }
}



fun fetchCategories():List<String>{
    return listOf("one","tow","three")
}







 //for text code
@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 300,
    heightDp = 200
)
@Composable
fun SimpleText() {
   Text(
       text = "Hello Krinal",
       color = Color.Black,
       modifier = Modifier
           .clickable { }
           .background(Color.Blue)
           .size(200.dp)
           .border(4.dp, color = Color.Red)
           .clip(CircleShape)
           .background(color = Color.Yellow)
   )

}

/*//for drawable image code

@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 200,
    heightDp = 200
)
@Composable
fun SimpleImage() {
    Image(painter = painterResource(id = R.drawable.simpleimg), contentDescription = "Dummy Img",
    //colorFilter = ColorFilter.tint(Color.Blue)
    )

}*/


// code for button

/*@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 400,
    heightDp = 100,
)
@Composable
fun SimpleImage() {
    Button(onClick = { }) {
        Text(text = "Login")
        Image(
            painter = painterResource(id = R.drawable.baseline_login_24),
            contentDescription = "Dummy"
        )

    }

}*/


/*//code for textField

@OptIn(ExperimentalMaterial3Api::class)
@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 500,
)
@Composable
fun SimpleTextField() {


    //code for box use set peramid

    Box() {
       Image(painter = painterResource(id = R.drawable.simpleimg), contentDescription = "")
        Image(painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24), contentDescription = "")
    }*/

   /* Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = "Hello Krinal", onValueChange = {
            Log.d("krinal",it)
        },
            label = { Text(text = "Enter Message")},

            )
        TextField(value = "Hello Krinal", onValueChange = {
            Log.d("krinal",it)
        },
            label = { Text(text = "Enter Message")},

            )

    }


}*/


/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextField() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value, onValueChange = {
           state.value = it
    },
        label = { Text(text = "Enter Message")},

    )


}*/




/*@Preview(showBackground = true, name = "firstString", showSystemUi = true, widthDp = 200, heightDp = 200)
@Composable
fun previwShow(){
    simpleText(name = "Krina")

}*/
/*@Preview(showBackground = true, name = "secondString")
@Composable
fun simpleText2 (name:String = "Krinal"){
    Text(text = "Hello $name")

}*/

