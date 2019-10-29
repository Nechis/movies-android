package com.leinaro.peiky.movies.Services

import android.util.Log
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.Models.MovieDBResponse
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository {

    private val services by lazy {
        create()
    }

    fun getPopularMovies(): Flowable<List<Movie>> {
        Log.e("iarl", "request ")

        return services.getPopularMovies()
            .map {
                it.results
            }
            .subscribeOn(Schedulers.io())

    }

    fun getTopRankedMovies(): Flowable<List<Movie>> {
        return services.getTopRankedMovies()
            .map {
                it.results
            }
            .subscribeOn(Schedulers.io())
    }

    fun getUpcomingMovies(): Flowable<List<Movie>> {
        return services.getUpcommingMovies()
            .map {
                it.results
            }
            .subscribeOn(Schedulers.io())
    }
}
