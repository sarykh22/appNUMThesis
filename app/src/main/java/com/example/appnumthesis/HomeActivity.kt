package com.example.appnumthesis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(HomeFragment())

        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.navigationButton)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.home_layouts -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.favorite_layouts -> {
                    replaceFragment(FavoriteFragment())
                    true
                }

                else -> {
                    replaceFragment(HomeFragment())
                    true
                }
            }
        }
    }


    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView, fragment)
        transaction.commit()
    }
}