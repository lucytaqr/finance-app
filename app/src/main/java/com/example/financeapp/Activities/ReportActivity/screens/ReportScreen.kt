package com.example.financeapp.Activities.ReportActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.financeapp.Activities.DashboardActivity.components.BottomNavigatorBar
import com.example.financeapp.Activities.ReportActivity.SummaryColums
import com.example.financeapp.Activities.ReportActivity.components.BudgetItem
import com.example.financeapp.Activities.ReportActivity.components.CenterStatsCard
import com.example.financeapp.Activities.ReportActivity.components.GradientHeader
import com.example.financeapp.Domain.BudgetDomain
import com.example.financeapp.R

@Composable
fun ReportScreen(
    budgets: List<BudgetDomain>,
    onBack: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (scrollRef, bottomNavRef) = createRefs()

        ReportContent(
            budgets = budgets,
            modifier = Modifier
                .constrainAs(scrollRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomNavRef.top)
                },
            onBack = onBack
        )

        BottomNavigatorBar(
            modifier = Modifier
                .height(80.dp)
                .constrainAs(bottomNavRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            onItemSelected = { itemId ->
                if (itemId == R.id.wallet) {

                }
            }
        )
    }
}

@Composable
fun ReportContent(
    budgets: List<BudgetDomain>,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
            ) {
                GradientHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    onBack = onBack
                )
                CenterStatsCard(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(horizontal = 24.dp)
                        .padding(bottom = 16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                )
            }
        }
        item {
            SummaryColums(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .background(
                        colorResource(R.color.lightBlue),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 16.dp, horizontal = 8.dp)
            )
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 12.dp)
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "My Budget",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colorResource(R.color.darkBlue)
                )
                Text(
                    "Edit",
                    color = colorResource(R.color.blue),
                    fontWeight = FontWeight.Medium
                )
            }
        }

        itemsIndexed(budgets) { index, item ->
            BudgetItem(budget = item, index = index)
        }
    }
}

@Preview
@Composable
fun ReportScreenPreview() {
    val budgets = listOf(
        BudgetDomain("Groceries", 100.0, 20.0),
        BudgetDomain("Rent", 500.0, 50.0),
        BudgetDomain("Entertainment", 50.0, 10.0),
    )
    ReportScreen(
        budgets = budgets,
        onBack = {}
    )
}
