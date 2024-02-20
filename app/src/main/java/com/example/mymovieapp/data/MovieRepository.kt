package com.example.mymovieapp.data

class MovieRepository private constructor( private val movieDao : MoviesDao ) {

    fun addMovie( movie : Movies ) {
        movieDao.addMovie( movie )
    }

    fun getMovies() = movieDao.getMovie()

    companion object {

        /* in volatile means to write to this property are immediately visible to other threats */
        @Volatile private var instance : MovieRepository? = null

        fun getInstance( movieDao: MoviesDao ) =
            /* if the instance is already not null if there is an instance already present it will going to return this instance */
            instance ?: synchronized( this ) {

                instance ?: MovieRepository( movieDao ).also {

                    instance = it

                }

            }
    }

}