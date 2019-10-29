package com.leinaro.peiky.movies

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.leinaro.peiky.movies.DataBase.MovieRoomDataBase
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

class MoviesApplication :Application(){

    val appModule = module {
        single <MovieRoomDataBase>{
            Room.databaseBuilder(
                this@MoviesApplication,
                MovieRoomDataBase::class.java,
                "movies.db"
            ).build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }

}
