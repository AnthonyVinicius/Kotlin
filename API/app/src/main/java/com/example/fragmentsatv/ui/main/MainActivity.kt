package com.example.fragmentsatv.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentsatv.databinding.ActivityMainBinding
import com.example.fragmentsatv.ui.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postViewModel: PostViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postViewModel.posts.observe(this) { posts ->
            val builder = StringBuilder()
            posts.forEach { post ->
                builder.append("ID: ${post.id}\nTítle: ${post.title}\n\n")
            }
            Log.d("MainActivity", builder.toString())
        }

        postViewModel.loadPosts()
    }
}