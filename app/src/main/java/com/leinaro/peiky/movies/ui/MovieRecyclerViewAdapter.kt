package com.leinaro.peiky.movies.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.R


import com.leinaro.peiky.movies.ui.MovieFragment.OnListFragmentInteractionListener

import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * [RecyclerView.Adapter] that can display a [Movie] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class MovieRecyclerViewAdapter(
    private var mValues: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val movie = v.tag as Movie
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(movie)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = mValues[position]
        holder.mTitleView.text = movie.title
        holder.mOverviewView.text = movie.overview
        Glide.with(holder.mImageView.context)
            .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
            .into(holder.mImageView)

        with(holder.mView) {
            tag = movie
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    fun setMovies(movies: List<Movie>) {
        this.mValues = movies
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mTitleView: TextView = mView.title
        val mOverviewView: TextView = mView.overview
        val mImageView: ImageView = mView.image

        override fun toString(): String {
            return super.toString() + " '" + mOverviewView.text + "'"
        }
    }
}
