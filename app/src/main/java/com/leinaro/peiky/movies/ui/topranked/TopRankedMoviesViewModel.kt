package com.leinaro.peiky.movies.ui.topranked

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.Services.Repository
import io.reactivex.android.schedulers.AndroidSchedulers

class TopRankedMoviesViewModel : ViewModel() {

    private val repository: Repository = Repository()

    val movies: MutableLiveData<List<Movie>> = MutableLiveData()

    init {

        val disposable = repository.getTopRankedMovies()
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