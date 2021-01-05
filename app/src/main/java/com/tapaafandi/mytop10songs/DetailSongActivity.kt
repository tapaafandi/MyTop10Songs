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

        val ivBack: ImageView = findViewById(R.id.ivBack)
        ivBack.setOnClickListener {
            finish()
        }
    }

    private fun showDataFromIntent() {
        val tvSongTitle: TextView = findViewById(R.id.tvSongTitle)
        val tvArtistName: TextView = findViewById(R.id.tvArtist)
        val tvFeaturing: TextView = findViewById(R.id.tvFeaturing)
        val tvProduceBy: TextView = findViewById(R.id.tvProduceBy)
        val tvAlbum: TextView = findViewById(R.id.tvSongAlbum)
        val tvReleaseDate: TextView = findViewById(R.id.tvReleaseDate)
        val ivSong: ImageView = findViewById(R.id.ivSong)

        intent.apply {
            tvSongTitle.text = getStringExtra("EXTRA_TITLE")
            tvArtistName.text = getStringExtra("EXTRA_ARTIST_NAME")
            tvFeaturing.text = getStringExtra("EXTRA_FEATURING")
            tvAlbum.text = getStringExtra("EXTRA_ALBUM")
            tvProduceBy.text = getStringExtra("EXTRA_PRODUCE_BY")
            tvReleaseDate.text = getStringExtra("EXTRA_RELEASE_DATE")
            val songImage = getIntExtra("EXTRA_SONG_IMAGE", R.drawable.song_placeholder)

            Glide.with(this@DetailSongActivity)
                .load(songImage)
                .into(ivSong)
        }
    }
}