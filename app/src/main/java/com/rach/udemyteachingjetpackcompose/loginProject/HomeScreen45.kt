package com.rach.udemyteachingjetpackcompose.loginProject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rach.udemyteachingjetpackcompose.R
import com.rach.udemyteachingjetpackcompose.ui.theme.UdemyTeachingJetPackComposeTheme
import com.rach.udemyteachingjetpackcompose.ui.theme.fontStyleCustom
import com.rach.udemyteachingjetpackcompose.ui.theme.greenColor

@Composable
fun LoginScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Surface(
            modifier = Modifier.size(35.dp),
            shape = CircleShape,
            tonalElevation = 4.dp,
            shadowElevation = 6.dp,
            color = Color.White
        ) {
            Image(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "KeyBoard Arrow Left",
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                fontSize = 35.sp,
                letterSpacing = 1.sp,
                style = TextStyle(
                    fontFamily = fontStyleCustom,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(
                modifier = Modifier.height(15.dp)
            )
            Text(
                text = stringResource(R.string.titleText),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                lineHeight = 20.sp,
                style = TextStyle(
                    fontFamily = fontStyleCustom,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )
        }

        CustomOutlinedTextFields(
            value = email,
            onValueChange = {
                email = it
            },
            label = "Email address",
            leadingIcon = Icons.Default.Email,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomOutlinedTextFields(
            value = password,
            onValueChange = {
                password = it
            },
            label = "Password",
            leadingIcon = Icons.Default.Lock,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            "Forgot Password",
            modifier = Modifier.align(Alignment.End),
            style = TextStyle(
                fontFamily = fontStyleCustom,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = greenColor
            )
        ) {
            Text(
                "Login", style = TextStyle(
                    fontFamily = fontStyleCustom,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            )
        }

    }
}

@Composable
fun CustomOutlinedTextFields(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions,
    leadingIcon: ImageVector,
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = label, style = TextStyle(
                    fontFamily = fontStyleCustom,
                    fontWeight = FontWeight.Medium
                ),
                fontSize = 17.sp
            )
        },
        keyboardOptions = keyboardOptions,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "Leading icon"
            )
        },
        shape = RoundedCornerShape(22.dp),
        maxLines = 1
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    UdemyTeachingJetPackComposeTheme {
        LoginScreen()
    }
}