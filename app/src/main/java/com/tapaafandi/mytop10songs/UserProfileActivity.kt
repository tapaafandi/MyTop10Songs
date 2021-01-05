package com.tapaafandi.mytop10songs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        getUserDataFromIntent()

        val ivBack: ImageView = findViewById(R.id.ivBack)
        ivBack.setOnClickListener {
            finish()
        }
    }

    private fun getUserDataFromIntent() {
        val tvName: TextView = findViewById(R.id.tvUserName)
        val tvEmail: TextView = findViewById(R.id.tvUserEmail)
        val ivUserImage: ImageView = findViewById(R.id.ivUserImage)
        intent.apply {
            tvName.text = getStringExtra("EXTRA_NAME")
            tvEmail.text = getStringExtra("EXTRA_EMAIL")
            val userImage = getIntExtra("EXTRA_USER_IMAGE", R.drawable.song_placeholder)

            Glide.with(this@UserProfileActivity)
                .load(userImage)
                .into(ivUserImage)
        }
    }
}