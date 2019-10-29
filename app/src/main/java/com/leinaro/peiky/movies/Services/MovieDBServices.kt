package com.leinaro.peiky.movies.Services

import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.Models.MovieDBResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface MovieDBServices {

    @GET("movie/popular?api_key=1f5d135f32a27896915244507699d125&language=en-US&page=1")
    fun getPopularMovies(): Flowable<MovieDBResponse>

    @GET("movie/upcoming?api_key=1f5d135f32a27896915244507699d125&language=en-US&page=1")
    fun getUpcommingMovies(): Flowable<MovieDBResponse>

    @GET("movie/top_rated?api_key=1f5d135f32a27896915244507699d125&language=en-US&page=1")
    fun getTopRankedMovies(): Flowable<MovieDBResponse>

}