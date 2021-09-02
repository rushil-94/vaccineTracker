package com.rushil.navigationexample.di.modules

import com.rushil.navigationexample.data.ApiService
import com.rushil.navigationexample.misc.CustomApplication
import com.rushil.navigationexample.misc.Utility
import com.rushil.navigationexample.repostories.NetWorkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Utility.getRetrofit()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideNetWorkRepository(apiService: ApiService): NetWorkRepository {
        return NetWorkRepository(apiService)
    }
}