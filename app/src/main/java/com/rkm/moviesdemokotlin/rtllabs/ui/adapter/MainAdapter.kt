package com.rkm.moviesdemokotlin.rtllabs.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rkm.moviesdemokotlin.R
import com.rkm.moviesdemokotlin.rtllabs.data.model.Movie
import com.rkm.moviesdemokotlin.rtllabs.util.IMAGE_BASE_URL
import com.rkm.moviesdemokotlin.rtllabs.util.IMAGE_FILE_SIZE
import kotlinx.android.synthetic.main.row_item.view.*

class MainAdapter(private val users:ArrayList<Movie>):RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(user: Movie) {
            itemView.apply {
                textViewUserName.text = user.title
                textViewUserEmail.text = user.releaseDate
                val image = IMAGE_BASE_URL + IMAGE_FILE_SIZE + user.posterPath
                Glide.with(imageViewAvatar.context)
                    .load(image)
                    .into(imageViewAvatar)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addUsers(users: List<Movie>) {
        this.users.apply {
            clear()
            addAll(users)
        }

    }
}