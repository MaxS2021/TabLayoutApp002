package com.example.tablayoutapp002

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.tablayoutapp002.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private lateinit var bind: Fragment3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bind = Fragment3Binding.inflate(inflater,container,false)

        return bind.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment3()
    }
}