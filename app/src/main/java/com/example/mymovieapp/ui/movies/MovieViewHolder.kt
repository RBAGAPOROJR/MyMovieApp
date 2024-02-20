package com.example.mymovieapp.ui.movies

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.R


class MovieViewHolder( itemView : View ) : RecyclerView.ViewHolder( itemView ) {

    val titleTextView: TextView = itemView.findViewById( R.id.titleTextView )
    val genreTextView: TextView = itemView.findViewById( R.id.genreTextView )

}
