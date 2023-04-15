package com.example.tablayoutapp002

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class Fragment2 : Fragment() {

    var play = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.fon_music1,
        R.raw.fon_music2,
        R.raw.fon_music3,
    )
    private val listNameMusic = ArrayList<String>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var mediaPlayer = MediaPlayer()
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        val listView = view.findViewById<ListView>(R.id.listV)
        val bStop = view.findViewById<Button>(R.id.bStop)
        listNameMusic.add("Trek 1")
        listNameMusic.add("Trek 2")
        listNameMusic.add("Trek 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listNameMusic)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, viewl, position, id ->
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, listMusic[position])
            mediaPlayer.start()
            Toast.makeText(requireContext(), "Выбран трек ${listNameMusic[position]}", Toast.LENGTH_LONG).show()
        }

        bStop.setOnClickListener {
            mediaPlayer.stop()
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}