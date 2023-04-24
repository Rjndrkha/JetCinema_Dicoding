package com.dicoding.rajendra.jettixid.ui.screen.cart

import com.dicoding.rajendra.jettixid.model.OrderReward


data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)