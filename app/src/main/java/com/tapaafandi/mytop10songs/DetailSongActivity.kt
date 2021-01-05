package com.tapaafandi.mytop10songs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailSongActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_song)

        showDataFromIntent()
    }

    private fun showDataFromIntent() {
        val tvSongTitle = findViewById<TextView>(R.id.tvSongTitle)
        val tvArtistName = findViewById<TextView>(R.id.tvArtist)
        val tvFeaturing = findViewById<TextView>(R.id.tvFeaturing)
        val tvProduceBy = findViewById<TextView>(R.id.tvProduceBy)
        val tvAlbum = findViewById<TextView>(R.id.tvSongAlbum)
        val ivSong: ImageView = findViewById(R.id.ivSong)

        intent.apply {
            tvSongTitle.text = getStringExtra("EXTRA_TITLE")
            tvArtistName.text = getStringExtra("EXTRA_ARTIST_NAME")
            tvFeaturing.text = getStringExtra("EXTRA_FEATURING")
            tvAlbum.text = getStringExtra("EXTRA_ALBUM")
            tvProduceBy.text = getStringExtra("EXTRA_PRODUCE_BY")
            val songImage = getIntExtra("EXTRA_SONG_IMAGE", R.drawable.song_placeholder)

            Glide.with(this@DetailSongActivity)
                .load(songImage)
                .into(ivSong)
        }
    }
}