package com.rushil.navigationexample.di.components

import com.rushil.navigationexample.di.ActivityScope
import com.rushil.navigationexample.ui.activities.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun build(): MainComponent
    }
}