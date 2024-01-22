package com.example.jetpackcomposelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposelearning.ui.theme.JetPackComposeLearningTheme

class ExRowCol : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                preview()
        }
    }
}



@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 500
)
@Composable
private  fun preview() {
   Column {
       ListViewItem(R.drawable.baseline_supervised_user_circle_24,"John Doe","Software Engineer")
       ListViewItem(R.drawable.baseline_supervised_user_circle_24,"John Doe","Software Engineer")
       ListViewItem(R.drawable.baseline_supervised_user_circle_24,"John Doe","Software Engineer")
       ListViewItem(R.drawable.baseline_supervised_user_circle_24,"John Doe","Software Engineer")
       ListViewItem(R.drawable.baseline_supervised_user_circle_24,"John Doe","Software Engineer")
   }
    //Image(painter = painterResource(id = R.drawable.simpleimg), contentDescription = "Dummy Img",
    //colorFilter = ColorFilter.tint(Color.Blue)
}
@Composable
fun ListViewItem(imgId : Int , name:String , occupation:String) {
    Row (Modifier .padding(8.dp)){
        Image(painter = painterResource(id = imgId),
            contentDescription = "",
            Modifier.size(40.dp)
        )
       Column() {
           Text(
               text = name,
               fontWeight = FontWeight.Bold
           )
           Text(
               text = occupation,
                fontWeight = FontWeight.Thin,
               fontSize = 12.sp
               )
        }    
    }
}

