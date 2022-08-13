package com.example.app_jamproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class MyPageFragment : Fragment() {
    private lateinit var image_view: ImageView
    val OPEN_CALLERY = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_page_fragment,container,false)
        return inflater.inflate(R.layout.my_page_fragment,container,false)
    }
}