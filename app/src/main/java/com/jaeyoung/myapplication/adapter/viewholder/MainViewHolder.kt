package com.jaeyoung.myapplication.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.jaeyoung.myapplication.R
import com.jaeyoung.myapplication.databinding.ListItemBinding
import com.jaeyoung.myapplication.presenter.MainViewHolderPresenter
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MainViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
    , MainViewHolderPresenter.View {
    private val _presenter = MainViewHolderPresenter(this)
    val presenter: MainViewHolderPresenter
        get() = _presenter

    override fun setName(name: String) {
        binding.tvTitle.text = name
    }

    override fun setSalary(salary: String) {
        binding.tvBody.text = String.format(Locale.getDefault(),
            binding.root.resources.getString(R.string.salary),
            DecimalFormat("#,###").format(salary.toLong()))
    }

}