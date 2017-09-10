package com.example.ayo.avkovalev.myapplication.di

import android.app.Application
import com.example.ayo.avkovalev.myapplication.AyoApplication
import com.example.ayo.avkovalev.myapplication.detailed.*
import com.example.ayo.avkovalev.myapplication.remote.OpenWeatherApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class ApplicationModule(private val application: AyoApplication) {

    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun provideApi(httpClient: OkHttpClient): OpenWeatherApi {
        return Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
                .create(OpenWeatherApi::class.java)

    }

    @Provides
    fun provideStorage(): WeatherStorage {
        return WeatherStorageImpl(application)
    }

    @Provides
    fun provideHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return client
    }

    @Provides
    fun provideInteractor(api: OpenWeatherApi, storage: WeatherStorage): DetailedInteractor {
        return DetailedInteractorImpl(api, storage)
    }

    @Provides
    fun providePresenter(interactor: DetailedInteractor): DetailedPresenter {
        return DetailedPresenterImpl(interactor)
    }

}