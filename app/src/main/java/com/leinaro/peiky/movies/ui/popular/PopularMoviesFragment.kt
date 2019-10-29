package com.leinaro.peiky.movies.ui.popular

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leinaro.peiky.movies.ui.MovieFragment

class PopularMoviesFragment : MovieFragment() {

    private lateinit var popularMoviesViewModel: PopularMoviesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)

        popularMoviesViewModel =
            ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)
        popularMoviesViewModel.movies.observe(this, Observer {
          it?.let {
              viewAdapter.setMovies(it)
          }
        })
        return root
    }
}