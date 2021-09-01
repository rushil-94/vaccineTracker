package com.rushil.navigationexample.di.components

import com.rushil.navigationexample.di.ActivityScope
import com.rushil.navigationexample.ui.activities.LoginActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface LoginComponent {
    fun inject(loginActivity: LoginActivity)

    @Subcomponent.Factory
    interface Factory {
        fun build(): LoginComponent
    }
}