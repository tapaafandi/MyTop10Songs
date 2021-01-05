package com.tapaafandi.mytop10songs.data

import com.tapaafandi.mytop10songs.R

object SongsData {

    private val artistName = listOf(
        "Eminem",
        "Eminem",
        "Eminem",
        "Logic",
        "Joyner Lucas",
        "Lil Wayne",
        "Lil Wayne",
        "NF",
        "Rich Brian",
        "Roddy Rich"
    )

    private val songTitle = listOf(
        "Gnat",
        "Godzilla (feat. Juice WRLD)",
        "Farewell",
        "Homicide (feat. Eminem)",
        "Isis (feat. Logic)",
        "Mona Lisa (feat. Kendrick Lamar)",
        "Open Letter",
        "I Miss The Days",
        "Drive Safe",
        "The Box"
    )

    private val songFeaturing = listOf(
        "-",
        "Juice WRLD",
        "-",
        "Eminem",
        "Logic",
        "Kendrick Lamar",
        "-",
        "-",
        "-",
        "-"
    )

    private val songProduceBy = listOf(
        "d.a. got that dope",
        "Eminem & d.a got that dope",
        "Ricky Racks & Eminem",
        "SHROOM & BREGMA",
        "Nox Beatz, Boi-1da & Rocktee",
        "ONHEL & Infamouse",
        "DJ Frank E, Johnny Yukon & Nick The Piff",
        "Tommee Profitt & NF",
        "The Donuts, Diamond Pistols",
        "Dat Boi Squeeze & 30 Roc"
    )

    private val songAlbum = listOf(
        "Music to Be Murdered By: Side B",
        "Music to Be Murdered By",
        "Music to Be Murdered By",
        "Confessions of a Dangerous Mind",
        "ADHD",
        "The Carter V",
        "The Carter V",
        "The Search",
        "The Sailor",
        "Please Excuse Me for Being Antisocial"
    )

    private val releaseDate = listOf(
        "December 18, 2020",
        "January 17, 2020",
        "January 17, 2020",
        "May 3, 2019",
        "May 23, 2019",
        "September 28, 2018",
        "September 28, 2018",
        "July 26, 2019",
        "July 26, 2019",
        "December 6, 2019",
    )

    private val songImages = listOf(
        R.drawable.eminem2,
        R.drawable.eminem,
        R.drawable.eminem,
        R.drawable.logic,
        R.drawable.joyner_lucas,
        R.drawable.lil_wayne,
        R.drawable.lil_wayne,
        R.drawable.nf,
        R.drawable.rich_brian,
        R.drawable.roddy_ricch
    )

    val listData: List<Songs>
        get() {
            val list = mutableListOf<Songs>()
            for (position in artistName.indices) {
                val song = Songs()
                song.name = artistName[position]
                song.title = songTitle[position]
                song.featruing = songFeaturing[position]
                song.album = songAlbum[position]
                song.produceBy = songProduceBy[position]
                song.songImage = songImages[position]
                list.add(song)
            }
            return list
        }
}