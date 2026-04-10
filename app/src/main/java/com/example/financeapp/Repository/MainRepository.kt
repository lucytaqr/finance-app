package com.example.financeapp.Repository

import com.example.financeapp.Domain.ExpenseDomain

class MainRepository {
    val items = mutableListOf(
        ExpenseDomain("Restaurant", 573.12, "restaurant", "17 Jun 2026 19:15"),
        ExpenseDomain("McDonald", 77.82, "mcdonald", "16 Jun 2026 13:57"),
        ExpenseDomain("Cinema", 23.47, "cinema", "16 Jun 2026 20:45"),
        ExpenseDomain("Restaurant", 573.12, "restaurant", "17 Jun 2026 22:18"),
    )
}