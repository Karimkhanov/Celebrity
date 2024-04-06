package com.example.celebritylab2.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.celebritylab2.R
import com.example.celebritylab2.databinding.ActivityMainBinding
import com.example.celebritylab2.fragment.CelebrityListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, CelebrityListFragment())
            .commit()


    }


}