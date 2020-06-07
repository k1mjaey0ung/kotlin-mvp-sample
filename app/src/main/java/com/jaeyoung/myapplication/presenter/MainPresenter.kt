package com.jaeyoung.myapplication.presenter

import com.jaeyoung.myapplication.data.domain.Data
import com.jaeyoung.myapplication.data.response.DataResponse
import com.jaeyoung.myapplication.repository.DataRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(private val view: MainPresenter.View) {

    private val disposable = CompositeDisposable()
    private val repository = DataRepository()

    fun clearDisposable() {
        disposable.clear()
    }

    fun fetchItems() {
        view.showLoadingIndicator()
        disposable.add(repository.create().getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(response: DataResponse) {
        view.hideLoadingIndicator()
        view.addItems(response.items)
    }

    private fun handleError(t: Throwable) {
        view.hideLoadingIndicator()
    }

    interface View {
        fun addItems(items: MutableList<Data>)
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
    }
}