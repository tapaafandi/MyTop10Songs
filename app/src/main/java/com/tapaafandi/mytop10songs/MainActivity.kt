package com.tapaafandi.mytop10songs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tapaafandi.mytop10songs.data.Songs
import com.tapaafandi.mytop10songs.data.SongsData
import com.tapaafandi.mytop10songs.data.Users
import com.tapaafandi.mytop10songs.data.UsersData

class MainActivity : AppCompatActivity() {

    private lateinit var rvSongs: RecyclerView
    private val listSong: ArrayList<Songs> = arrayListOf()
    private val user = UsersData.user

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MyTop10Songs)
        setContentView(R.layout.activity_main)

        rvSongs = findViewById(R.id.rvSongs)
        rvSongs.setHasFixedSize(true)

        listSong.addAll(SongsData.listData)
        showRecyclerList()
        setUserProfileImage()

        val ivUserProfile = findViewById<ImageView>(R.id.ivCircleProfileImage)
        ivUserProfile.setOnClickListener {
            Intent(this, UserProfileActivity::class.java).apply {
                putExtra("EXTRA_NAME", user.name)
                putExtra("EXTRA_EMAIL", user.email)
                putExtra("EXTRA_USER_IMAGE", user.userImage)
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

    private fun setUserProfileImage() {
        val ivUserImage: ImageView = findViewById(R.id.ivCircleProfileImage)
        Glide.with(this)
            .load(user.userImage)
            .into(ivUserImage)
    }
}