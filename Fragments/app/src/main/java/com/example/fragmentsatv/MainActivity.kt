package com.example.fragmentsatv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentsatv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Fragment1())

        binding.buttomNav.setOnSelectedLister { item ->
            when (item.itenId) {
                R.id.id_home -> replaceFragment(Fragment1())
                R.id.id_user -> replaceFragment(Fragment2())
                R.id.id_product -> replaceFragment(Fragment3())
            }

        }true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}




