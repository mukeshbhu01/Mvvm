package com.mks.mvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mks.mvvm.viewmodel.HomeViewModel
import com.mks.mvvm.model.Model
import com.mks.mvvm.viewmodel.ViewModelFactory
import com.mks.mvvm.appconfig.MvvmApp
import com.mks.mvvm.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    private lateinit var adapter: HomeListAdapter

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        setSupportActionBar(homeBinding.appToolbar)
        supportActionBar.apply { title = "Home" }

        initHomeViewModel()
        initHomeView()
    }

    private fun initHomeView() {
        val recyclerView = homeBinding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HomeListAdapter(emptyList(),this)
        recyclerView.adapter = adapter
    }

    private fun initHomeViewModel() {
        homeViewModel.uiModelData.observe(this, modelObserver)
    }

    private val modelObserver = Observer<Model> {
        adapter.updateModel(it.data)
    }

}