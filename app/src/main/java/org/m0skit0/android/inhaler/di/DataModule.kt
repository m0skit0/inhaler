package org.m0skit0.android.inhaler.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import org.m0skit0.android.inhaler.data.PunchRepository
import org.m0skit0.android.inhaler.data.PunchRepositoryImpl
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import org.m0skit0.android.inhaler.data.stats.StatisticsCalculator
import org.m0skit0.android.inhaler.data.stats.StatisticsCalculatorImpl
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModuleBind {

    @Binds
    @Singleton
    abstract fun bindPunchRepository(repository: PunchRepositoryImpl): PunchRepository

    @Binds
    @Singleton
    abstract fun bindStatisticsCalculator(repository: StatisticsCalculatorImpl): StatisticsCalculator
}

@Module
@InstallIn(ApplicationComponent::class)
class DataModuleProvider {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext applicationContext: Context): InhalerDatabase =
        Room
            .databaseBuilder(
                applicationContext,
                InhalerDatabase::class.java,
                InhalerDatabase.NAME
            ).build()
}
