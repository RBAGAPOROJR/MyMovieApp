package com.example.mymovieapp.ui.movies

import androidx.lifecycle.ViewModel
import com.example.mymovieapp.data.MovieRepository
import com.example.mymovieapp.data.Movies

class MoviesVM( private val movieRepository : MovieRepository ) : ViewModel() {

    fun getMovies() = movieRepository.getMovies()

    fun addMovies( movie : Movies ) = movieRepository.addMovie( movie )

}