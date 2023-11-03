package com.example.jetsynapsissubmission.presentation.screen.survei

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.example.jetsynapsissubmission.presentation.component.SurveiCard
import com.example.jetsynapsissubmission.presentation.navigation.Screen

@Composable
fun SurveiScreen(
    navHostController: NavHostController,
    viewModel: SurveiViewModel = hiltViewModel()
) {
    val navOptions = NavOptions.Builder()
        .setPopUpTo(Screen.Survei.route, inclusive = true) // Hapus SurveiScreen dari backstack
        .build()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Halaman Survey",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF121212),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.padding(bottom = 25.5.dp, top = 34.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.ExitToApp,
                contentDescription = "Logout",
                modifier = Modifier
                    .offset(y = 5.dp)
                    .clickable {
                        viewModel.clearPref()
                        navHostController.navigate(Screen.Login.route, navOptions)
                    }
            )
        }
        for (i in 1..4) {
            SurveiCard(surveiType = i.toString())
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

