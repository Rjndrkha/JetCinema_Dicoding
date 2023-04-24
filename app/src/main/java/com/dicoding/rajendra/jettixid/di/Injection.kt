package com.dicoding.rajendra.jettixid.di

import com.dicoding.rajendra.jettixid.data.RewardRepository


object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}