package com.rushil.navigationexample.di.components

import android.app.Application
import com.rushil.navigationexample.di.modules.ContextModule
import com.rushil.navigationexample.di.modules.LoginModule
import com.rushil.navigationexample.di.modules.MainModule
import com.rushil.navigationexample.di.modules.NetworkModule
import com.rushil.navigationexample.ui.activities.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ContextModule::class, LoginModule::class, MainModule::class])
interface ApplicationComponent {

    fun getLoginComponent(): LoginComponent.Factory
    fun getMainComponent(): MainComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}