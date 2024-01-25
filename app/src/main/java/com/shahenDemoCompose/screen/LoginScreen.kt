package com.shahenDemoCompose.screen

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetpackcomposelearning.R
import com.shahenDemoCompose.ui.theme.edt_border_color
import com.shahenDemoCompose.viewModel.LoginViewModel


@Composable
fun LoginScreen(
    context: Context = LocalContext.current,
    navController: NavHostController = NavHostController(context),
    onLoginSuccess: () -> Unit

) {
    val viewModel: LoginViewModel = hiltViewModel()
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
        LoginScreenUI(context, onLoginSuccess)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenUI(
    context: Context = LocalContext.current,
   // navController: () -> Unit = NavHostController(context),
    onLoginSuccess: () -> Unit
) {

    val viewModel: LoginViewModel = hiltViewModel()
    val context = LocalContext.current
    //val scaffoldState: ScaffoldState = rememberScaffoldState()

    val isLoadingState = viewModel.isLoadingState.collectAsState().value
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val loginErrorMsg = viewModel.loginErrorMsg.collectAsState().value





    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF30A5DE), Color(0xFF8BCFF0), Color(0xFFffffff)),
                )
            )
    ) {
        Column(
            modifier = Modifier
                .padding(top = 90.dp)
                .align(Alignment.TopStart),
        ) {

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.login_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(221.dp, 130.dp)
                        .clip(MaterialTheme.shapes.medium),

                    //.padding(top = 10.dp, start = 8.dp, end = 8.dp)

                )
            }

            Text(
                text = "Welcome Back!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 18.sp,
                // fontFamily = FontFamily(Font(R.font.manrope_medium))
            )

            Text(
                text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                textAlign = TextAlign.Center,
                color = Color.White,
                fontSize = 24.sp,
                // fontFamily = FontFamily(Font(R.font.manrope_bold))

            )

            Card(
                modifier = Modifier
                    //.fillMaxWidth(0.8f)
                    .padding(top = 18.dp, start = 16.dp, end = 16.dp)
                    //.background(Color.White)
                    .align(Alignment.CenterHorizontally),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                ),
                shape = RoundedCornerShape(16.dp),
                //shape = MaterialTheme.shapes.medium,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    // Email Field
                    OutlinedTextField(
                        value = emailState.text,
                        onValueChange = { input ->
                            viewModel.setEmail(input)
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = edt_border_color,
                            //unfocusedBorderColor = edt_border_color
                        ),
                        maxLines = 1,
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),
                        // label = { Text("Email") },
                        isError = emailState.error != "",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Email,
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        },
                        modifier = Modifier.fillMaxWidth()

                        )

                    if (emailState.error != "") {
                        Text(
                            text = emailState.error ?: "",
                            color = Color.Red
                        )
                    }

                    // Password Field
                    var passwordVisibility by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = passwordState.text,
                        onValueChange = { input ->
                            viewModel.setPassword(input)
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = edt_border_color,
                            //unfocusedBorderColor = edt_border_color
                        ),
                        maxLines = 1,
                        singleLine = true,
                        shape = RoundedCornerShape(12.dp),

                        //label = { Text("Password") },

                        isError = passwordState.error != "",

                        trailingIcon = {
                            Box(
                                modifier = Modifier
                                    .clickable { passwordVisibility = !passwordVisibility }
                                    .padding(8.dp)
                            ) {
                                Text(
                                    text = if (passwordVisibility) "Hide" else "Show",
                                    color = colorResource(id = R.color.darkBlue),
                                    fontSize = 14.sp
                                )
                            }
                        },

                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Lock,
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        },
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                    )

                    if (passwordState.error != "") {
                        Text(
                            text = passwordState.error ?: "",
                            color = Color.Red,
                        )
                    }


                    Text(
                        text = "Forgot Password?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 14.dp),
                        textAlign = TextAlign.End,
                        color = colorResource(id = R.color.darkBlue),
                        fontSize = 14.sp,
                        // fontFamily = FontFamily(Font(R.font.manrope_bold))

                    )

                    // Login Button
                    Button(
                        onClick = {

                            viewModel.isValid {
                                    // Handle login logic here
                                    onLoginSuccess.invoke()
                                }

                            // Handle login logic here
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.darkBlue))


                    ) {
                        /* Icon(
                             imageVector = Icons.Default.Send,
                             contentDescription = null,
                             tint = Color.White,
                             modifier = Modifier.size(18.dp)
                         )*/
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Login")
                    }

                }

            }

            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Don't have an account? ")
                }
                withStyle(style = SpanStyle(color = colorResource(id = R.color.darkBlue))) {
                    append("Register")
                }
            }

            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 130.dp),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
            )
        }
    }
}



