package com.tapaafandi.mytop10songs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tapaafandi.mytop10songs.data.Songs
import com.tapaafandi.mytop10songs.data.SongsData

class MainActivity : AppCompatActivity() {

    private lateinit var rvSongs: RecyclerView
    private var listSong: ArrayList<Songs> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSongs = findViewById(R.id.rvSongs)
        rvSongs.setHasFixedSize(true)

        listSong.addAll(SongsData.listData)
        showAllSongs()

        val ivUserProfile = findViewById<ImageView>(R.id.ivCircleProfileImage)
        ivUserProfile.setOnClickListener {
            Intent(this, UserProfileActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun showAllSongs() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val songAdapter = SongAdapter(listSong)
        rvSongs.adapter = songAdapter
    }
}