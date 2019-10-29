package com.leinaro.peiky.movies.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.leinaro.peiky.movies.Models.Movie
import io.reactivex.Flowable

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movies: List<Movie>)

    @Query("SELECT * FROM movie_table")
    fun getMovies(): Flowable<List<Movie>>

    @Query("SELECT * FROM movie_table INNER JOIN category_movie_table ON category_movie_table.movie_id = movie_table.id WHERE category_movie_table.category_id = 1 ORDER BY category_movie_table.position" )
    fun getPopularMovies(): Flowable<List<Movie>>

    @Query("SELECT * FROM movie_table INNER JOIN category_movie_table ON category_movie_table.movie_id = movie_table.id WHERE category_movie_table.category_id = 2 ORDER BY category_movie_table.position" )
    fun getTopRankedMovies(): Flowable<List<Movie>>

    @Query("SELECT * FROM movie_table INNER JOIN category_movie_table ON category_movie_table.movie_id = movie_table.id WHERE category_movie_table.category_id = 3 ORDER BY category_movie_table.position" )
    fun getUpcomingMovies(): Flowable<List<Movie>>
}
