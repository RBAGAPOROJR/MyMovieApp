package com.example.mymovieapp.ui.movies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.R
import com.example.mymovieapp.data.Movies

class MovieAdapter : RecyclerView.Adapter< MovieViewHolder >() {

    private var movies: List< Movies > = listOf()

    fun submitList( updatedMovies: List< Movies > ) {

        movies = updatedMovies

    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): MovieViewHolder {

        val itemView = LayoutInflater.from( parent.context )
            .inflate( R.layout.movie_item, parent, false )
        return MovieViewHolder( itemView )

    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder( holder: MovieViewHolder, position: Int ) {

        val movie = movies[ position ]

        holder.titleTextView.text = "Title : ${ movie.movTitle }"
        holder.genreTextView.text = "Genre : ${ movie.movGenre }"

    }

    override fun getItemCount(): Int {

        return movies.size

    }
}
