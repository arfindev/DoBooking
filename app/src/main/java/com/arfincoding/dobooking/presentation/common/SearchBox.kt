package com.arfincoding.dobooking.presentation.home_screen.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arfincoding.dobooking.R
import com.arfincoding.dobooking.ui.theme.CustomGrey
import com.arfincoding.dobooking.ui.theme.LightGreen400


@Composable
fun SearchBox(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onClosedClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                modifier = Modifier
                    .weight(5f)
                    .height(50.dp),
                value = text,
                onValueChange = {
                    onTextChange(it)
                },
                shape = RoundedCornerShape(10.dp),
                placeholder = {
                    Text(
                        text = "Place",
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (isSystemInDarkTheme()) CustomGrey else CustomGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearchClicked(text)
                })
            )
            Spacer(modifier = Modifier.width(10.dp))
            TextField(
                modifier = Modifier
                    .weight(5f)
                    .height(50.dp),
                value = text,
                onValueChange = {
                    onTextChange(it)
                },
                shape = RoundedCornerShape(10.dp),
                placeholder = {
                    Text(
                        text = "Guests",
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (isSystemInDarkTheme()) CustomGrey else CustomGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearchClicked(text)
                })
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextField(
                modifier = Modifier
                    .weight(5f)
                    .height(50.dp),
                value = text,
                onValueChange = {
                    onTextChange(it)
                },
                shape = RoundedCornerShape(10.dp),
                placeholder = {
                    Text(
                        text = "Guests",
                        color = Color.DarkGray,
                        fontSize = 13.sp
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = if (isSystemInDarkTheme()) CustomGrey else CustomGrey,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardActions = KeyboardActions(onSearch = {
                    onSearchClicked(text)
                })
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth().height(50.dp)
                .padding(start = 20.dp, end = 20.dp), shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LightGreen400,
                contentColor = Color.White
            )
        ) {
            Text(text = "Search Hotel")
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun PreviewSearchBox() {
    SearchBox()

}*/
