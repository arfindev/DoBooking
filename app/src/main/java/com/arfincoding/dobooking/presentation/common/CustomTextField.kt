package com.arfincoding.dobooking.presentation.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arfincoding.dobooking.ui.theme.LightGray100
import com.arfincoding.dobooking.ui.theme.LightGreen400

@Composable
fun CustomTextField(
    value: String,
    modifier: Modifier = Modifier,
    isPasswordTextField: Boolean ,
    onValueChange: (String) -> Unit,
    placeHolder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default

) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = LightGreen400,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = Color.Black,
            backgroundColor = LightGray100,
        ), shape = RoundedCornerShape(8.dp), singleLine = true,
        placeholder = placeHolder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = if (isPasswordTextField) PasswordVisualTransformation() else VisualTransformation.None,
    )

}

@Preview(showBackground = true)
@Composable
fun PreviewCustomTextField() {
    CustomTextField(
        value = "Email",
        onValueChange = {
        }, placeHolder = {
            Text(text = "")
        }
    , isPasswordTextField = false)

}