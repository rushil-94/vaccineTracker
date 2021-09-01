package com.rushil.navigationexample.di.modules

import com.rushil.navigationexample.di.components.LoginComponent
import dagger.Module

@Module(subcomponents = [LoginComponent::class])
class LoginModule