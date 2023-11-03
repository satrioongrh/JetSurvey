package com.example.jetsynapsissubmission.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetsynapsissubmission.R
import com.example.jetsynapsissubmission.ui.theme.JetSynapsisSubmissionTheme

@Composable
fun SurveiCard(surveiType: String) {
    Column(
        verticalArrangement = Arrangement.spacedBy(17.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFD9D9D9),
                shape = RoundedCornerShape(size = 4.dp)
            )
            .fillMaxWidth()
            .height(78.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 4.dp))
            .padding(12.dp)
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(54.dp)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = surveiType,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                        letterSpacing = 0.4.sp,
                    )
                )
                Text(
                    text = "Created At: 23 Jan 2023",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF107C41),
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SurveiCardPrev() {
    JetSynapsisSubmissionTheme {
        SurveiCard("survei a")
    }
}