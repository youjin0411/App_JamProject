package com.example.app_jamproject

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.media.audiofx.DynamicsProcessing
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var drawerToggle: ActionBarDrawerToggle

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.drawer_nav_view)
        val btnprofile = findViewById<ImageButton>(R.id.btn_profil)
        val rink1 = findViewById<ImageButton>(R.id.rink1)
        val rink2 = findViewById<ImageButton>(R.id.rink2)
        val rink3 = findViewById<ImageButton>(R.id.rink3)
        val rink4 = findViewById<ImageButton>(R.id.rink4)

        btnprofile.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.frame,MyPageFragment()).setReorderingAllowed(true).addToBackStack(null).commit()
        }
        rink1.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=XcfGcrq1KYY"))
            startActivity(intent)
        }
        rink2.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=yjfz_nWZQS8"))
            startActivity(intent)
        }
        rink3.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=4q6SxxG6p8k"))
            startActivity(intent)
        }
        rink4.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/KBOrdtBq9-Y"))
            startActivity(intent)
        }

        //??? ????????? ?????? ????????? ???????????? item ????????? ??????
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.baby_boom -> Toast.makeText(this,"???????????????",Toast.LENGTH_SHORT).show()
                R.id.baby_boom -> Toast.makeText(this,"???????????? ??????",Toast.LENGTH_SHORT).show()
                R.id.generation_X -> Toast.makeText(this,"X ??????",Toast.LENGTH_SHORT).show()
                R.id.millennium -> Toast.makeText(this,"???????????? ??????",Toast.LENGTH_SHORT).show()
                R.id.generation_Z -> Toast.makeText(this,"Z ??????",Toast.LENGTH_SHORT).show()
            }
            //?????? ????????? ??????????????? ???????????? ?????? ????????? ??????
            drawerLayout.closeDrawers()

            true
        }

        val mainpage = MainActivity()
        val fragment_baby= BabyBoomFragment()
        val fragment_mille = Millennium_fragment()
        val fragment_x = XFragment()
        val fragment_z = ZFragment()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.mainpage -> {
                    val nextIntent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(nextIntent)
                }
                R.id.baby_boom -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment_baby).setReorderingAllowed(true).addToBackStack(null).commit()
                }
                R.id.generation_X -> {

                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment_x).setReorderingAllowed(true).addToBackStack(null).commit()
                }
                R.id.millennium -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment_mille).setReorderingAllowed(true).addToBackStack(null).commit()
                }
                R.id.generation_Z -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, fragment_z).setReorderingAllowed(true).addToBackStack(null).commit()
                }
            }
            //?????? ????????? ??????????????? ???????????? ?????? ????????? ??????
            drawerLayout.closeDrawers()

            true
        }

        drawerToggle = object : ActionBarDrawerToggle(this,drawerLayout, R.string.drawer_open,R.string.drawer_close){}
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)

        drawerToggle.syncState()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}