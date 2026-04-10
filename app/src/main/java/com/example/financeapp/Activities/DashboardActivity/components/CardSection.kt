package com.example.financeapp.Activities.DashboardActivity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financeapp.R

@Composable
@Preview
fun CardSection(onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(230.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        // 1. Background Image
        Image(
            painter = painterResource(R.drawable.card),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        // 2. Konten Utama (Disusun secara Vertikal)
        Column(modifier = Modifier.fillMaxSize()) {

            // Bagian Atas: Logo Visa & SIM
            Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Image(
                    painter = painterResource(R.drawable.visa),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterStart)
                )
                Image(
                    painter = painterResource(R.drawable.sim),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            // Bagian Tengah: Nomor Kartu & Tanggal
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(1f), // Mengambil sisa ruang agar balance terdorong ke bawah
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "1234 5678 9012 3456",
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = "03/07",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            // 3. Bagian Bawah: Balance (Box Transparan)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp) // Tinggi tetap untuk area balance
                    .background(Color.White.copy(alpha = 0.2f))
                    .padding(16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column {
                    Text(
                        text = "Your Balance",
                        color = Color.White,
                        fontSize = 17.sp
                    )
                    Text(
                        text = "$ 23,451.58",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}