package com.leinaro.peiky.movies.ui.upcoming

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.MoviesApplication
import com.leinaro.peiky.movies.Services.Repository
import io.reactivex.android.schedulers.AndroidSchedulers

class UpcomingMoviesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = Repository(application as MoviesApplication)

    val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    init {

        val disposable = repository.getUpcomingMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    movies.postValue(result)
                },
                { error ->
                    Log.e("iarl", "viewmodel error "+error.printStackTrace())
                },
                {
                    Log.e("iarl", "viewmodel completed ")
                }
            )
    }
}