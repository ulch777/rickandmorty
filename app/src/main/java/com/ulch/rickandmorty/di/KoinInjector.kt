package com.ulch.rickandmorty.di

import android.content.Context
import com.ulch.rickandmorty.data.ResponseHandler
import com.ulch.rickandmorty.models.network.api.Api
import com.ulch.rickandmorty.repository.Repository
import com.ulch.rickandmorty.repository.RepositoryImpl
import com.ulch.rickandmorty.ui.character_list.CharacterListViewModel
import com.ulch.rickandmorty.ui.episode_list.EpisodeListViewModel
import com.ulch.rickandmorty.ui.locationl_list.LocationListViewModel
import com.ulch.rickandmorty.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object KoinInjector {
    fun setup(context: Context) {
        startKoin {
            androidContext(context)
            modules(listOf(viewModelsModule, managersModule, repositoryModule))
        }
    }

    private val repositoryModule = module {
        factory<Repository> { RepositoryImpl(get()) }
    }

    private val managersModule = module {
        single { ResponseHandler() }
        factory { provideOkHttpClient() }
        factory { providePaymentApi(get()) }
        single { provideRetrofit(get()) }

    }

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    }

    private fun providePaymentApi(retrofit: Retrofit): Api =
        retrofit.create(Api::class.java)

    private val viewModelsModule = module {
        viewModel { CharacterListViewModel(get()) }
        viewModel { LocationListViewModel(get()) }
        viewModel { EpisodeListViewModel(get()) }
    }
}