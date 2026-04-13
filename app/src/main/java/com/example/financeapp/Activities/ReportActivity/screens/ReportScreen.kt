package com.example.financeapp.Activities.ReportActivity.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.financeapp.Activities.ReportActivity.components.CenterStatsCard
import com.example.financeapp.Activities.ReportActivity.components.GradientHeader
import com.example.financeapp.Domain.BudgetDomain

@Composable
fun ReportScreen(
    budgets: List<BudgetDomain>,
    onBack: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (scrollRef, bottomBarRef) = createRefs()

        ReportContent(
            budgets = budgets,
            modifier = Modifier
                .constrainAs(scrollRef) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
//                    bottom.linkTo(parent.top)
                },
            onBack = onBack
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
            .background(Color.White),

        ) {
        item {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
            ) {
                val (header, card) = createRefs()
                GradientHeader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .constrainAs(header) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)

                        },
                    onBack = onBack
                )
                CenterStatsCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 24.dp)
                        .constrainAs(card){
                            top.linkTo(header.bottom)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
            }
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

