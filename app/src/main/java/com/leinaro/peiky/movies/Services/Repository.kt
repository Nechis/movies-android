package com.leinaro.peiky.movies.Services

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import com.leinaro.peiky.movies.DataBase.CategoryDao
import com.leinaro.peiky.movies.DataBase.CategoryMovieDao
import com.leinaro.peiky.movies.DataBase.MovieDao
import com.leinaro.peiky.movies.DataBase.MovieRoomDataBase
import com.leinaro.peiky.movies.Models.*
import com.leinaro.peiky.movies.MoviesApplication
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.inject
import java.util.*

class Repository(application: MoviesApplication) {

    private var movieDao: MovieDao
    private var categoryDao: CategoryDao
    private var categoryMovieDao: CategoryMovieDao

    private val services by lazy {
        create()
    }

    init {
        val db: MovieRoomDataBase by application.inject()
        movieDao = db.movieDao()
        categoryDao = db.categoryDao()
        categoryMovieDao = db.categoryMovieDao()
    }

    fun getPopularMovies(): Flowable<List<Movie>> {
        return services.getPopularMovies()
            .doOnNext {
                Log.e("iarl", "create category")
                categoryDao.insertCategory(Category(id = 1, category = "popular"))
            }
            .map {
                Log.e("iarl", "get movies")
                it.results
            }
            .doOnNext {
                Log.e("iarl", "saved movies")
                movieDao.insertAll(it)
            }
            .doOnNext {
                Log.e("iarl", "saved movies movies by category")

                val categoryMovies = it.mapIndexed { index, movie ->
                    CategoryMovie(position = index, category_id = 1, movie_id = movie.id)
                }
                categoryMovieDao.insertAll(categoryMovies)
            }
            .onErrorResumeNext(
                movieDao.getPopularMovies()
            )
            .subscribeOn(Schedulers.io())

    }

    fun getTopRankedMovies(): Flowable<List<Movie>> {
        return services.getTopRankedMovies()
            .doOnNext {
                Log.e("iarl", "create category")
                categoryDao.insertCategory(Category(id = 2, category = "topranked"))
            }
            .map {
                Log.e("iarl", "get movies")
                it.results
            }
            .doOnNext {
                Log.e("iarl", "saved movies")
                movieDao.insertAll(it)
            }
            .doOnNext {
                Log.e("iarl", "saved movies movies by category")

                val categoryMovies = it.mapIndexed { index, movie ->
                    CategoryMovie(position = index, category_id = 2, movie_id = movie.id)
                }
                categoryMovieDao.insertAll(categoryMovies)
            }
            .onErrorResumeNext(
                movieDao.getTopRankedMovies()
            )
            .subscribeOn(Schedulers.io())
    }

    fun getUpcomingMovies(): Flowable<List<Movie>> {
        return services.getUpcommingMovies()
            .doOnNext {
                Log.e("iarl", "create category")
                categoryDao.insertCategory(Category(id = 3, category = "upcoming"))
            }
            .map {
                Log.e("iarl", "get movies")
                it.results
            }
            .doOnNext {
                Log.e("iarl", "saved movies")
                movieDao.insertAll(it)
            }
            .doOnNext {
                Log.e("iarl", "saved movies movies by category")

                val categoryMovies = it.mapIndexed { index, movie ->
                    CategoryMovie(position = index, category_id = 3, movie_id = movie.id)
                }
                categoryMovieDao.insertAll(categoryMovies)
            }
            .onErrorResumeNext(
                movieDao.getUpcomingMovies()
            )
            .subscribeOn(Schedulers.io())
    }
}
