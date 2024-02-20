package com.example.mymovieapp.utilities

import com.example.mymovieapp.data.MockDatabase
import com.example.mymovieapp.data.MovieRepository
import com.example.mymovieapp.ui.movies.MoviesVMFactory

object InjectorUtils {

    fun provideMoviesVMFactory() : MoviesVMFactory {

        val moviesRepository = MovieRepository.getInstance( MockDatabase.getInstance().movieDao )
        return  MoviesVMFactory( moviesRepository )
    }
}