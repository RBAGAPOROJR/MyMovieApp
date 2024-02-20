package com.example.mymovieapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/*  DAO = Data Access Objectives
- to store your app's data
- you interact with the stored data by defining data access objects */
class MoviesDao {

    private val movieList = mutableListOf< Movies >()
    private val movies = MutableLiveData< List< Movies > > ()

    init {

        movies.value = movieList

    }

    fun addMovie( movie: Movies ) {

        movieList.add( movie )
        movies.value = movieList

    }

    fun getMovie() = movies as LiveData< List< Movies > >

}