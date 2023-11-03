package com.example.jetsynapsissubmission.presentation.screen.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.jetsynapsissubmission.presentation.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navHostController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var stateCheckBox by remember { mutableStateOf(false) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    val res by viewModel.login
    val context = LocalContext.current

    val sessionActive = viewModel.getSessionLogin()

    if (sessionActive == true) {
        navHostController.navigate(Screen.Survei.route)
        return
    } else if (sessionActive == null || !sessionActive) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Login to synapsis",
                style = TextStyle(
                    fontSize = 21.sp,
                    lineHeight = 27.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF121212),
                ),
                modifier = Modifier
                    .padding(bottom = 24.dp, top = 34.dp)
            )
            Text(
                text = "Email",
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFB9B9B9),
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Password",
                style = TextStyle(
                    fontSize = 13.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFFB9B9B9),
                ),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.AccountCircle else
                        Icons.Outlined.AccountCircle

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        androidx.compose.material3.Icon(
                            imageVector = image,
                            contentDescription = null
                        )

                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF757575),
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = stateCheckBox,
                    onCheckedChange = { stateCheckBox = !stateCheckBox },
                    modifier = Modifier.offset(x = -12.dp)
                )
                Text(
                    text = "Remember me",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757575),
                    ), modifier = Modifier.offset(x = -12.dp)
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            Button(
                onClick = {
                    viewModel.doLogin(email, password)
                },

                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(43.dp)
                    .background(color = Color(0xFF1FA0C9), shape = RoundedCornerShape(size = 4.dp))

            ) {
                if (res.isLoading == true) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Text(
                    text = "Log in",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )

            }
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "or",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF1FA0C9),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1FA0C9),
                        shape = RoundedCornerShape(size = 4.dp)
                    )
                    .fillMaxWidth()
                    .height(43.dp)
            ) {
                Text(
                    text = "Fingerprint",
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 27.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF1FA0C9),

                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }



    if (res.data?.code == 200) {
        if (stateCheckBox) {
            viewModel.storeSessionLogin(true)
        }
        Log.d("02123", "LoginScreen: ${viewModel.getSessionLogin()}")
        navHostController.navigate(Screen.Survei.route)
    } else if (res.error != null) {
        Toast.makeText(context, res.error, Toast.LENGTH_SHORT).show()
    }
}