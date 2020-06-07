package com.jaeyoung.myapplication.presenter

import com.jaeyoung.myapplication.data.domain.Data

class MainViewHolderPresenter(private val view: MainViewHolderPresenter.View) {

    fun bindView(presenter: MainAdapterPresenter, position: Int) {
        val data: Data? = presenter.getItem(position)

        if(data != null) {
            view.setName(data.name)
            view.setSalary(data.salary)
        }
    }

    interface View {
        fun setName(name: String)
        fun setSalary(salary: String)
    }
}