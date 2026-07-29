package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Class
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme

private val LiceoMaroon = Color(0xFF7A1F2B)
private val LiceoMaroonLight = Color(0xFFE7C6CB)
private val LiceoGold = Color(0xFFA67C2E)
private val LiceoGoldLight = Color(0xFFF0DFB0)
private val LiceoCream = Color(0xFFFFFBFA)
private val LiceoInk = Color(0xFF201A1B)
private val LiceoMuted = Color(0xFF8A7A7C)
private val LiceoDivider = Color(0xFFE5DDDE)

private val LiceoCardDark = Color(0xFF2A1418)
private val LiceoInkDark = Color(0xFFF0E6E7)
private val LiceoMutedDark = Color(0xFFB99FA3)
private val LiceoDividerDark = Color(0xFF4A2E33)

@Composable
fun ProfileScreen() {
    MyApplicationTheme {
        val isDark = isSystemInDarkTheme()
        val cardBg = if (isDark) LiceoCardDark else LiceoCream
        val inkColor = if (isDark) LiceoInkDark else LiceoInk
        val mutedColor = if (isDark) LiceoMutedDark else LiceoMuted
        val dividerColor = if (isDark) LiceoDividerDark else LiceoDivider

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(cardBg)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(LiceoMaroon)
                    .padding(top = 32.dp, bottom = 40.dp, start = 20.dp, end = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "LICEO DE CAGAYAN UNIVERSITY",
                    fontSize = 11.sp,
                    letterSpacing = 1.5.sp,
                    color = LiceoMaroonLight
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = "Student Identification Profile",
                    fontSize = 12.sp,
                    color = LiceoGoldLight
                )

                Spacer(Modifier.height(20.dp))

                Image(
                    painter = painterResource(id = R.drawable.profile_photo),
                    contentDescription = "Profile photo of Sydny Jane R. Quinquino",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(84.dp)
                        .clip(CircleShape)
                        .border(3.dp, LiceoGoldLight, CircleShape)
                )

                Spacer(Modifier.height(16.dp))

                Text(
                    text = "Sydny Jane R. Quinquino",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Medium,
                    color = LiceoCream
                )

                Spacer(Modifier.height(2.dp))

                Text(
                    text = "BSIT 3-2",
                    fontSize = 13.sp,
                    color = LiceoMaroonLight
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-20).dp)
                    .padding(horizontal = 0.dp),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)) {
                    InfoRow(
                        icon = Icons.Default.Person,
                        label = "Full Name",
                        value = "Sydny Jane R. Quinquino",
                        inkColor = inkColor,
                        mutedColor = mutedColor
                    )
                    HorizontalDivider(color = dividerColor)

                    InfoRow(
                        icon = Icons.Default.School,
                        label = "Course",
                        value = "BSIT - Bachelor of Science in Information Technology",
                        inkColor = inkColor,
                        mutedColor = mutedColor
                    )
                    HorizontalDivider(color = dividerColor)

                    InfoRow(
                        icon = Icons.Default.Class,
                        label = "Section",
                        value = "3-2",
                        inkColor = inkColor,
                        mutedColor = mutedColor
                    )
                    HorizontalDivider(color = dividerColor)

                    InfoRow(
                        icon = Icons.Default.Phone,
                        label = "Mobile Number",
                        value = "09950736853",
                        inkColor = inkColor,
                        mutedColor = mutedColor
                    )
                    HorizontalDivider(color = dividerColor)

                    InfoRow(
                        icon = Icons.Default.Email,
                        label = "Email Address",
                        value = "sjquinquino71936@liceo.edu.ph",
                        inkColor = inkColor,
                        mutedColor = mutedColor
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String, inkColor: Color, mutedColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = LiceoMaroon,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = label,
                fontSize = 11.sp,
                letterSpacing = 0.4.sp,
                color = mutedColor
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = value,
                fontSize = 14.sp,
                color = inkColor
            )
        }
    }
}

@Preview(showBackground = true, name = "Profile — Light")
@Composable
fun ProfileScreenLightPreview() {
    ProfileScreen()
}

@Preview(showBackground = true, name = "Profile — Dark", uiMode = 0x20)
@Composable
fun ProfileScreenDarkPreview() {
    ProfileScreen()
}