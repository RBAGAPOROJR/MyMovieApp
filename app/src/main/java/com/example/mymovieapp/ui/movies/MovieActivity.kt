package com.example.mymovieapp.ui.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.mymovieapp.R
import com.example.mymovieapp.data.Movies
import com.example.mymovieapp.utilities.InjectorUtils
//import kotlinx.android.synthetic.main.activity_movie.*
import com.example.mymovieapp.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate( savedInstanceState: Bundle? ) {

        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate( layoutInflater )
        setContentView( binding.root )

        initializeUI()

    }

    private fun initializeUI() {

        val factory = InjectorUtils.provideMoviesVMFactory()
        val viewModel = ViewModelProviders.of( this, factory )
            .get( MoviesVM::class.java )

        viewModel.getMovies().observe(this, Observer { movies ->

            val stringBuilder = StringBuilder()
            movies.forEach{ movie ->

                stringBuilder.append( "$movie" )

            }

            val adapter = MovieAdapter()

            binding.recyclerView.adapter = adapter

            viewModel.getMovies().observe(this, Observer { updatedMovies ->

                adapter.submitList( updatedMovies )

            } )

        } )

        binding.btnSaveMovies.setOnClickListener {

            val movie = Movies( binding.editTxtTitle.text.toString(), binding.editTxtGenre.text.toString() )
            viewModel.addMovies( movie )

            binding.editTxtTitle.setText("")
            binding.editTxtGenre.setText("")

        }

    }
}