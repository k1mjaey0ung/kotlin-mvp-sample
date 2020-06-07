package com.jaeyoung.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaeyoung.myapplication.R
import com.jaeyoung.myapplication.adapter.MainAdapter
import com.jaeyoung.myapplication.data.domain.Data
import com.jaeyoung.myapplication.databinding.ActivityMainBinding
import com.jaeyoung.myapplication.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private lateinit var binding: ActivityMainBinding;
    private val presenter = MainPresenter(this)
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerView()
        start()
    }

    override fun onDestroy() {
        presenter.clearDisposable()
        super.onDestroy()
    }

    private fun setRecyclerView() {
        with(binding.rvContents) {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
                .apply {
                    orientation = LinearLayoutManager.VERTICAL
                }
            this.adapter = this@MainActivity.adapter
        }
    }

    private fun start() {
        presenter.fetchItems()
    }

    override fun addItems(items: MutableList<Data>) {
        adapter.presenter.addItems(items)
    }

    override fun showLoadingIndicator() {

    }

    override fun hideLoadingIndicator() {

    }
}
