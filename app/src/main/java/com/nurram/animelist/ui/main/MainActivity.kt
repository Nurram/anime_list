package com.nurram.animelist.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nurram.animelist.R
import com.nurram.animelist.databinding.ActivityMainBinding
import com.nurram.animelist.utils.Status
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding
    lateinit var adapter: MainAdapter

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        adapter = MainAdapter()
        dataBinding.recyclerview.adapter = adapter
        dataBinding.recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.getTopAnimes()
        viewModel.animes.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> it.data?.top?.let { it1 ->
                    adapter.setData(it1)
                }
                Status.LOADING -> dataBinding.progress.visibility = View.VISIBLE
                else -> Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
            }
        })
    }
}