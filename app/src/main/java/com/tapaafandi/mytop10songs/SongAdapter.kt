package com.tapaafandi.mytop10songs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tapaafandi.mytop10songs.data.Songs

class SongAdapter(private val songs: ArrayList<Songs>) : RecyclerView.Adapter<SongAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvArtistName: TextView = itemView.findViewById(R.id.tvArtistName)
        var tvSongTitle: TextView = itemView.findViewById(R.id.tvSongTitle)
        var ivSong: ImageView = itemView.findViewById(R.id.ivSongImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_song, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val song = songs[position]

        Glide.with(holder.itemView.context)
            .load(song.songImage)
            .apply(RequestOptions().override(55, 55))
            .into(holder.ivSong)

        holder.tvArtistName.text = song.name
        holder.tvSongTitle.text = song.title

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(songs[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {
        return songs.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Songs)
    }
}