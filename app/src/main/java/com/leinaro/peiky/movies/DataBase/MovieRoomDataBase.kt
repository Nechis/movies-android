package com.leinaro.peiky.movies.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leinaro.peiky.movies.Models.Category
import com.leinaro.peiky.movies.Models.CategoryMovie
import com.leinaro.peiky.movies.Models.Movie

@Database(entities = arrayOf(
    Movie::class, Category::class, CategoryMovie::class
), version = 1)
abstract class MovieRoomDataBase: RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun categoryDao(): CategoryDao
    abstract fun categoryMovieDao(): CategoryMovieDao
}