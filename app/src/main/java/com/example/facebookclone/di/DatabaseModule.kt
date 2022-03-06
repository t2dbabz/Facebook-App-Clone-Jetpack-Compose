package com.example.facebookclone.di

import android.content.Context
import androidx.room.Room
import com.example.facebookclone.data.PostDatabase
import com.example.facebookclone.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        PostDatabase::class.java,
        DATABASE_NAME
    ).build()


    @Singleton
    @Provides
    fun provideDao(database: PostDatabase) = database.postDao()

}