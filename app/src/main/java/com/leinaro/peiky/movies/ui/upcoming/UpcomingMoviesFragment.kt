package com.leinaro.peiky.movies.ui.upcoming

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.leinaro.peiky.movies.ui.MovieFragment

class UpcomingMoviesFragment : MovieFragment() {

    private lateinit var upcomingMoviesViewModel: UpcomingMoviesViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = super.onCreateView(inflater, container, savedInstanceState)

        upcomingMoviesViewModel =
                ViewModelProviders.of(this).get(UpcomingMoviesViewModel::class.java)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
        upcomingMoviesViewModel.movies.observe(this, Observer {
            it?.let {
                viewAdapter.setMovies(it)
            }
        })
        return root
    }
}