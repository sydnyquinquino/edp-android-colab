package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val NavyDark = Color(0xFF0B1F3A)
private val NavyMid = Color(0xFF13315C)
private val AccentBlue = Color(0xFF2F6FED)
private val TextPrimary = Color(0xFF1A1D23)
private val TextSecondary = Color(0xFF6B7280)
private val SurfaceSoft = Color(0xFFF6F8FB)
private val BorderSoft = Color(0xFFE7EAF0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SurfaceSoft
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

private const val HEADER_HEIGHT_DP = 140
private const val AVATAR_SIZE_DP = 130

private val avatarOverlap = (AVATAR_SIZE_DP / 2).dp

@Composable
fun BusinessCard() {
    androidx.compose.animation.AnimatedVisibility(
        visible = true,
        enter = fadeIn() + slideInVertically(initialOffsetY = { 300 })
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(18.dp, RoundedCornerShape(28.dp), clip = false),
                shape = RoundedCornerShape(28.dp),
                elevation = CardDefaults.cardElevation(0.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.White, Color(0xFFFCFDFF), SurfaceSoft),
                                startY = 0f
                            )
                        )
                ) {
                    // faint corner accent for texture, sits behind everything
                    Canvas(modifier = Modifier.matchParentSize()) {
                        drawCircle(
                            color = AccentBlue.copy(alpha = 0.05f),
                            radius = 220f,
                            center = Offset(size.width + 40f, size.height - 60f)
                        )
                        drawCircle(
                            color = NavyMid.copy(alpha = 0.04f),
                            radius = 160f,
                            center = Offset(-30f, size.height * 0.55f)
                        )
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        // ----- Header + avatar -----
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                // extra room at the bottom so the avatar can overlap
                                // without covering the header art
                                .height((HEADER_HEIGHT_DP.dp + avatarOverlap)),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            HeaderArt(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(HEADER_HEIGHT_DP.dp)
                            )

                            Avatar(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .size(AVATAR_SIZE_DP.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Sydny Jane Quinquiño",
                            fontFamily = FontFamily.Serif,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.2.sp,
                            color = TextPrimary,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "BS INFORMATION TECHNOLOGY",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.8.sp,
                            color = AccentBlue,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            thickness = 1.dp,
                            color = BorderSoft
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        SectionLabel("CONTACT")

                        Spacer(modifier = Modifier.height(12.dp))

                        Column(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            ContactRow(Icons.Default.Phone, "0995 073 6853")
                            ContactRow(Icons.Default.Email, "sjquinquino71936@liceo.edu.ph")
                            ContactRow(Icons.Default.LocationOn, "Cagayan de Oro City")
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 32.dp),
                            thickness = 1.dp,
                            color = BorderSoft
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        SocialSection()

                        Spacer(modifier = Modifier.height(28.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun HeaderArt(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.linearGradient(
                        colors = listOf(NavyDark, NavyMid, AccentBlue)
                    )
                )
        )
        Canvas(modifier = Modifier.fillMaxSize()) {
            rotate(20f) {
                drawRect(
                    color = Color.White.copy(alpha = .05f),
                    topLeft = Offset(30f, 10f),
                    size = Size(320f, 70f)
                )
                drawRect(
                    color = Color.White.copy(alpha = .04f),
                    topLeft = Offset(230f, 110f),
                    size = Size(240f, 55f)
                )
            }
            drawCircle(
                color = Color.White.copy(alpha = .08f),
                radius = 100f,
                center = Offset(size.width - 50f, 30f)
            )
            drawLine(
                color = Color.White.copy(alpha = .15f),
                start = Offset(0f, size.height * 0.75f),
                end = Offset(size.width, size.height * 0.55f),
                strokeWidth = 4f,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
private fun Avatar(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.profile_photo),
        contentDescription = "Profile photo",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(CircleShape)
            .border(4.dp, Color.White, CircleShape)
            .shadow(8.dp, CircleShape)
    )
}

@Composable
private fun SectionLabel(text: String) {
    Text(
        text = text,
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp,
        color = TextSecondary
    )
}

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(SurfaceSoft)
            .padding(vertical = 12.dp, horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(AccentBlue.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AccentBlue,
                modifier = Modifier.size(18.dp)
            )
        }
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary,
            maxLines = 1
        )
    }
}

@Composable
fun SocialSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SectionLabel("CONNECT")

        Spacer(modifier = Modifier.height(12.dp))

        SocialChip(Icons.Default.Language, "GitHub")

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Digital Business Card",
            fontSize = 12.sp,
            color = TextSecondary
        )
    }
}

@Composable
fun SocialChip(icon: ImageVector, label: String) {
    Card(
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.dp, BorderSoft),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(icon, contentDescription = null, tint = AccentBlue, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text(label, fontSize = 13.sp, color = TextPrimary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MaterialTheme {
        BusinessCard()
    }
}
