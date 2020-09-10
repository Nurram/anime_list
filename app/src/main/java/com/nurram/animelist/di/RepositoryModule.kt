package com.nurram.animelist.di

import com.nurram.animelist.ui.main.MainRepo
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepo(get()) }
}