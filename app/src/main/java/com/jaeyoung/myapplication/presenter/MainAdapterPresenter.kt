package com.jaeyoung.myapplication.presenter

import com.jaeyoung.myapplication.data.domain.Data

class MainAdapterPresenter (
    private val view: MainAdapterPresenter.View
) {

    private var items: MutableList<Data>? = null

    fun addItems(items: MutableList<Data>) {
        if(this.items.isNullOrEmpty()) {
            this.items = items
        } else {
            this.items?.addAll(items)
        }

        view.notifyAdapter()
    }

    fun getItemCount(): Int {
        return if(items.isNullOrEmpty()) 0 else items!!.size
    }

    fun getItem(position: Int): Data? {
        return if(items.isNullOrEmpty()) null else items!![position]
    }

    interface View {
        fun notifyAdapter()
    }
}