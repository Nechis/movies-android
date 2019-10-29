package com.leinaro.peiky.movies.ui.popular

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.Services.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularMoviesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository = Repository()

    val movies: MutableLiveData<List<Movie>> = MutableLiveData()


    init {

        val disposable = repository.getPopularMovies()
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