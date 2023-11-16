package com.example.task1.di

import com.example.task1.BuildConfig
import com.example.task1.data.api.WeatherAlertApi
import com.example.task1.tools.Constants.BASE_WEATHER_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory


@Module
@InstallIn(SingletonComponent::class)
class WeatherAppModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Singleton
    @Provides
    fun provideToHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(interceptor)
        }
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideApi(): WeatherAlertApi =
        Retrofit.Builder()
            .baseUrl(BASE_WEATHER_API_URL)
            .client(provideToHttpClient(provideLoggingInterceptor()))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(WeatherAlertApi::class.java)
}