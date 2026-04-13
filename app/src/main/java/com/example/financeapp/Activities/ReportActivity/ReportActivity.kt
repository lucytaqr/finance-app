package com.example.financeapp.Activities.ReportActivity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.financeapp.Activities.ReportActivity.screens.ReportScreen
import com.example.financeapp.ViewModel.MainViewModel

class ReportActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReportScreen(
                budgets = mainViewModel.loadBudget(),
                onBack = { finish() }
            )
        }
    }
}
