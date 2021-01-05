package com.tapaafandi.mytop10songs.data

import com.tapaafandi.mytop10songs.R

object UsersData {

    private const val name: String = "Mustafa Afandi"
    private const val email: String = "tapaafandi@gmail.com"
    private const val image: Int = R.drawable.my_photo_profile

    val listUser : Users
        get() {
            val user = Users()
            user.name = name
            user.email = email
            user.userImage = image
            return user
        }
}