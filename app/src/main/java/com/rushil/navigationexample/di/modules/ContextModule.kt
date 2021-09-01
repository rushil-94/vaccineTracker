package com.rushil.navigationexample.di.modules

import android.app.Application
import android.content.Context
import com.rushil.navigationexample.misc.CustomApplication
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

}