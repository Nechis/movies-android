package com.leinaro.peiky.movies.ui.popular

import android.os.Bundle
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
     //   val textView: TextView = root.findViewById(R.id.text_home)

        popularMoviesViewModel =
            ViewModelProviders.of(this).get(PopularMoviesViewModel::class.java)
        popularMoviesViewModel.text.observe(this, Observer {
          //  textView.text = it
        })
        return root
    }
}