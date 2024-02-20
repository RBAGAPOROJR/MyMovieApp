package com.example.mymovieapp.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mymovieapp.data.MovieRepository

class MoviesVMFactory( private val  movieRepository : MovieRepository ) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun < T : ViewModel > create( modelClass: Class< T > ) : T {

        return MoviesVM( movieRepository ) as T

    }
}