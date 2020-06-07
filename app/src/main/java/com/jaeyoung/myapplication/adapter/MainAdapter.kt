package com.jaeyoung.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jaeyoung.myapplication.adapter.viewholder.MainViewHolder
import com.jaeyoung.myapplication.databinding.ListItemBinding
import com.jaeyoung.myapplication.presenter.MainAdapterPresenter

class MainAdapter : RecyclerView.Adapter<MainViewHolder>(), MainAdapterPresenter.View {

    private val _presenter = MainAdapterPresenter(this)
    val presenter: MainAdapterPresenter
        get() = _presenter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return _presenter.getItemCount()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.presenter.bindView(_presenter, position)
    }

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }
}