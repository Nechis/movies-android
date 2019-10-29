package com.leinaro.peiky.movies.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leinaro.peiky.movies.Models.CategoryMovie
import com.leinaro.peiky.movies.Models.Movie
import io.reactivex.Flowable

@Dao
interface CategoryMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categorymovies: List<CategoryMovie>)
}
