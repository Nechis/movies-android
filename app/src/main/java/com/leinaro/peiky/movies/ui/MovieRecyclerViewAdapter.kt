package com.leinaro.peiky.movies.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.leinaro.peiky.movies.Models.Movie
import com.leinaro.peiky.movies.R


import com.leinaro.peiky.movies.ui.MovieFragment.OnListFragmentInteractionListener
import com.leinaro.peiky.movies.ui.dummy.DummyContent.DummyItem

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
        val item = mValues[position]
        holder.mIdView.text = item.id.toString()
        holder.mContentView.text = item.title

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    fun setMovies(movies: List<Movie>) {
        this.mValues = movies
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
