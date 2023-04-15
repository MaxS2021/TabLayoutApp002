package com.example.tablayoutapp002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tablayoutapp002.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    private val listFragment = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )
    private val listFrName = listOf(
        "Музыка",
        "Фото",
        "Видео"
    )
    private val listFrBadge = listOf(
        15,
        6,
        110
    )
    private val listFrIcom = listOf(
        R.drawable.ic_baseline_library_music_24,
        R.drawable.ic_baseline_image_24,
        R.drawable.ic_baseline_video_library_24
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val adapter = VpAdapter(this, listFragment)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.tabL, bind.vp2) {
            tab, pos ->
            //tab.text = listFrName[pos]
            tab.icon = ContextCompat.getDrawable(this,listFrIcom[pos])
            val badge = tab.orCreateBadge
            //badge.backgroundColor = ContextCompat.getColor(this, R.color.teal_700)
            badge.number = listFrBadge[pos]
        }.attach()

    }
}