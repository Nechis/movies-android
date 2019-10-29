package com.leinaro.peiky.movies.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leinaro.peiky.movies.Models.Category
import com.leinaro.peiky.movies.Models.Movie
import io.reactivex.Flowable

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): Flowable<List<Movie>>

}
