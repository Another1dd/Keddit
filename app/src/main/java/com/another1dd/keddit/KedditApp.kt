package com.another1dd.keddit

import android.app.Application
import com.another1dd.keddit.di.AppModule
import com.another1dd.keddit.di.news.DaggerNewsComponent
import com.another1dd.keddit.di.news.NewsComponent

class KedditApp : Application(){

    companion object {
        lateinit var newsComponent : NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}