package com.arfincoding.dobooking.presentation.signin_screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.arfincoding.dobooking.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.arfincoding.dobooking.navigation.Screens
import com.arfincoding.dobooking.auth.AuthResult
import com.arfincoding.dobooking.presentation.common.CustomTextField
import com.arfincoding.dobooking.ui.AuthUiEvent
import com.arfincoding.dobooking.ui.MainViewModel
import com.arfincoding.dobooking.ui.theme.LightGreen400
import com.arfincoding.dobooking.ui.theme.RegularFont


@Composable
fun SignInScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    val state = viewModel.state
    val context = LocalContext.current
    LaunchedEffect(viewModel, context) {
        viewModel.authResults.collect { result ->
            when (result) {
                is AuthResult.Authorized -> {
                    navController.navigate(Screens.HomeScreen.route) {
                        popUpTo(Screens.AuthScreen.route) {
                            inclusive = true
                        }
                    }
                }
                is AuthResult.Unauthorized -> {
                    Toast.makeText(context, "You're not authorized", Toast.LENGTH_LONG).show()
                }
                is AuthResult.UnknownError -> {
                    Toast.makeText(context, "An unknown error occurred", Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.openeye)
    } else {
        painterResource(id = R.drawable.hideeye)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .padding(start = 30.dp, end = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 15.dp),
            text = "Create Account",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            fontFamily = RegularFont,
            style = TextStyle(color = if (isSystemInDarkTheme()) Color.White else Color.Black)
        )
        Text(
            text = "Create to Continue",
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            fontFamily = RegularFont,
            style = TextStyle(color = if (isSystemInDarkTheme()) Color.White else Color.Black)

        )
        CustomTextField(value = state.signUpUsername, onValueChange = {
            viewModel.onEvent(AuthUiEvent.SignUpUsernameChanged(it))
        }, placeHolder = {
            Text(
                text = "Email",
                fontFamily = RegularFont,
                fontSize = 14.sp,
                style = TextStyle()
            )
        }, leadingIcon = {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = R.drawable.mail),
                contentDescription = ""
            )
        }, isPasswordTextField = false, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        Spacer(modifier = Modifier.height(16.dp))
        CustomTextField(
            value = state.signUpPassword,
            onValueChange = {
                viewModel.onEvent(AuthUiEvent.SignUpPasswordChanged(it))
            },
            isPasswordTextField = !passwordVisibility,
            modifier = Modifier.fillMaxWidth(),
            placeHolder = {
                Text(
                    text = stringResource(R.string.password),
                    fontFamily = RegularFont,
                    fontSize = 14.sp
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = stringResource(R.string.lock_icon)

                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon",
                        modifier = Modifier.size(18.dp)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            keyboardActions = KeyboardActions(onDone = KeyboardActions.Default.onDone)

        )
        Text(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 20.dp, top = 10.dp),
            text = stringResource(R.string.forgot_password),
            fontWeight = FontWeight.SemiBold, color = Color.Red, fontFamily = RegularFont,

            )
        Button(
            onClick = {
                viewModel.onEvent(AuthUiEvent.SignUp)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp)
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(30.dp), colors = ButtonDefaults.buttonColors(
                backgroundColor = LightGreen400, contentColor = Color.White
            )
        ) {
            Text(
                text = "Sign up",
                fontFamily = RegularFont,
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

        }
        Text(
            modifier = Modifier
                .padding(15.dp)
                .clickable {

                },
            text = "Don't have an account? sign up",
            fontWeight = FontWeight.Bold, color = Color.Black, fontFamily = RegularFont
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 20.dp,
                ),
            text = "or continue with",
            fontWeight = FontWeight.Medium, color = Color.Gray, fontFamily = RegularFont
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            IconButton(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(30.dp)),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(30.dp)),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook Icon",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(30.dp)),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = "Twitter Icon",
                    tint = Color.Unspecified
                )
            }
        }
    }
    if (state.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignInScreen() {

    SignInScreen(
        navController = rememberNavController(),
        viewModel = hiltViewModel()
    )
}