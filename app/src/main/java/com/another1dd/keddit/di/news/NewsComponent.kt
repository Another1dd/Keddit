package com.another1dd.keddit.di.news

import com.another1dd.keddit.di.AppModule
import com.another1dd.keddit.di.NetworkModule
import com.another1dd.keddit.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)

interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}