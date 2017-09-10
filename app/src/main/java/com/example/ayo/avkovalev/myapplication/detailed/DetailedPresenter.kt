package com.example.ayo.avkovalev.myapplication.detailed

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

interface DetailedPresenter {

    fun attachView(view: DetailedView)

    fun detachView()

    fun load(lon: Double, lat: Double)

}


class DetailedPresenterImpl(private val interactor: DetailedInteractor) : DetailedPresenter {

    private var disposable: Disposable? = null
    private var view: DetailedView? = null

    override fun attachView(view: DetailedView) {
        this.view = view
    }

    override fun load(lon: Double, lat: Double) {
        disposable = interactor.loadWeather(lon, lat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.setCityName(it.name)
                    view?.setTemperature(it.main.temp)
                }, { Log.e("DetailedPresenterImpl", it.message) })
    }

    override fun detachView() {
        disposable?.dispose()
        this.view = null
    }
}