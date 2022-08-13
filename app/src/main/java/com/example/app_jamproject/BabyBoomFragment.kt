package com.example.app_jamproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import java.util.zip.Inflater

//val btnBaby = findViewById<ImageButton>(R.id.btn_baby)
//val btnmili = findViewById<ImageButton>(R.id.btn_mili)
//val btnx = findViewById<ImageButton>(R.id.btn_x)
//val btnz = findViewById<ImageButton>(R.id.btn_z)
//
//btnBaby.setOnClickListener {
//    val intent = Intent(this@MainActivity, MainActivity::class.java)
//    startActivity(intent)
//}
class BabyBoomFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.baby_boom_fragment,container,false)

    }
}