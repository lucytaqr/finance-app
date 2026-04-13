package com.example.financeapp.Activities.DashboardActivity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.financeapp.Activities.DashboardActivity.screens.MainScreen
import com.example.financeapp.Activities.ReportActivity.ReportActivity
import com.example.financeapp.ViewModel.MainViewModel
import com.example.financeapp.ui.theme.FinanceAppTheme

class MainActivity : ComponentActivity() {
    private  val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinanceAppTheme {
                MainScreen(expenses = mainViewModel.loadData(), onCardClick = {
                    startActivity(Intent(this, ReportActivity::class.java))
                })
            }
        }
    }
}