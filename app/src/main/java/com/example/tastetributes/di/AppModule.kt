package com.example.tastetributes.di

import android.content.Context
import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.database.db.TasteTributesDatabase
import com.example.tastetributes.datastore.DataStoreHelper
import com.example.tastetributes.navigation.NavigationManager
import com.example.tastetributes.utils.FirebaseAuthService
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideFireBaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun provideFirebaseAuthService(@ApplicationContext context: Context, auth: FirebaseAuth): FirebaseAuthService {
        return FirebaseAuthService(context, auth)
    }

    @Singleton
    @Provides
    fun provideTasteTributeDatabase(@ApplicationContext context: Context): TasteTributesDatabase {
        return TasteTributesDatabase.invoke(context)
    }

    @Provides
    fun provideUserDao(database: TasteTributesDatabase): UserDao = database.getUserInfoDao()

    @Provides
    fun providesNavigationManager(): NavigationManager {
        return NavigationManager(CoroutineScope(Dispatchers.Main))
    }

    @Singleton
    @Provides
    fun provideDataStoreHelper(
        @ApplicationContext context: Context
    ): DataStoreHelper = DataStoreHelper(context)
}