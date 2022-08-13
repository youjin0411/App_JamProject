package com.example.app_jamproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.drawer_nav_view)

        supportFragmentManager.beginTransaction().add(R.id.frame, BabyBoomFragment()).commit()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.baby_boom -> supportFragmentManager.beginTransaction().replace(R.id.frame,BabyBoomFragment()).commit()
                R.id.generation_X -> supportFragmentManager.beginTransaction().replace(R.id.frame,XFragment()).commit()
                R.id.millennium -> supportFragmentManager.beginTransaction().replace(R.id.frame,Millennium_fragment()).commit()
                R.id.generation_Z -> supportFragmentManager.beginTransaction().replace(R.id.frame,ZFragment()).commit()
            }
            drawerLayout.closeDrawers()

            true
        }
        //각 메뉴에 대한 내용을 정리하는 item 요소를 추가
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.baby_boom -> Toast.makeText(this,"베이비봄 세대",Toast.LENGTH_SHORT).show()
                R.id.generation_X -> Toast.makeText(this,"X 세대",Toast.LENGTH_SHORT).show()
                R.id.millennium -> Toast.makeText(this,"밀레니엄 세대",Toast.LENGTH_SHORT).show()
                R.id.generation_Z -> Toast.makeText(this,"Z 세대",Toast.LENGTH_SHORT).show()
            }
            //어떤 메뉴를 선택했는지 구분하기 위해 식별자 부여
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