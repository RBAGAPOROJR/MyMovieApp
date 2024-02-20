package com.example.mymovieapp.data

class MockDatabase private constructor() {

    var movieDao = MoviesDao()
        private set

    companion object {

        /* in volatile means to write to this property are immediately visible to other threats */
        @Volatile private var instance : MockDatabase? = null

        fun getInstance() =
            /* if the instance is already not null if there is an instance already present it will going to return this instance */
            instance ?: synchronized( this ) {

                instance ?: MockDatabase().also {

                    instance = it

                }

            }
    }
}