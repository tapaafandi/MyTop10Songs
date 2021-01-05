package com.tapaafandi.mytop10songs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
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
        showRecyclerList()

        val ivUserProfile = findViewById<ImageView>(R.id.ivCircleProfileImage)
        ivUserProfile.setOnClickListener {
            Intent(this, UserProfileActivity::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun showRecyclerList() {
        rvSongs.layoutManager = LinearLayoutManager(this)
        val songAdapter = SongAdapter(listSong)
        rvSongs.adapter = songAdapter

        songAdapter.setOnItemClickCallback(object : SongAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Songs) {
                Intent(this@MainActivity, DetailSongActivity::class.java).apply {
                    putExtra("EXTRA_TITLE", data.title)
                    putExtra("EXTRA_ARTIST_NAME", data.name)
                    putExtra("EXTRA_SONG_IMAGE", data.songImage)
                    putExtra("EXTRA_FEATURING", data.featruing)
                    putExtra("EXTRA_ALBUM", data.album)
                    putExtra("EXTRA_PRODUCE_BY", data.produceBy)
                    startActivity(this)
                }
            }
        })
    }

    private fun showSelectedSong(song: Songs) {
        Toast.makeText(this, song.name, Toast.LENGTH_SHORT).show()
    }
}