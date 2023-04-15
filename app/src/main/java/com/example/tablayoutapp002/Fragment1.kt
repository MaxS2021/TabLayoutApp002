package com.example.tablayoutapp002

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment1 : Fragment() {

    var play = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.fon_music1,
        R.raw.fon_music2,
        R.raw.fon_music3,
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer.create(context, listMusic[trek])
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val bMusic = view.findViewById<Button>(R.id.bMusic)
        bMusic.setOnClickListener {
            if (!play) {
                mediaPlayer.start()
                play = true
                trek += 1
                if (trek > 2) trek = 0
            } else {
                mediaPlayer.stop()
                play = false
                mediaPlayer = MediaPlayer.create(context, listMusic[trek])
            }
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}