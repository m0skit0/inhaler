package org.m0skit0.android.inhaler.di

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import org.m0skit0.android.inhaler.data.punch.PunchRepository
import org.m0skit0.android.inhaler.data.punch.PunchRepositoryImpl
import org.m0skit0.android.inhaler.data.punch.PunchRepositoryMock
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import org.m0skit0.android.inhaler.data.stats.StatisticsRepository
import org.m0skit0.android.inhaler.data.stats.StatisticsRepositoryImpl
import org.m0skit0.android.inhaler.data.stats.StatisticsRepositoryMock
import javax.inject.Named
import javax.inject.Singleton

const val NAMED_PUNCH_REPOSITORY_MOCK = "NAMED_PUNCH_REPOSITORY_MOCK"
const val NAMED_PUNCH_REPOSITORY_REAL = "NAMED_PUNCH_REPOSITORY_REAL"
const val NAMED_STATISTICS_REPOSITORY_MOCK = "NAMED_STATISTICS_REPOSITORY_MOCK"
const val NAMED_STATISTICS_REPOSITORY_REAL = "NAMED_STATISTICS_REPOSITORY_REAL"

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModuleBind {

    @Binds
    @Singleton
    @Named(NAMED_PUNCH_REPOSITORY_REAL)
    abstract fun bindPunchRepository(repository: PunchRepositoryImpl): PunchRepository

    @Binds
    @Singleton
    @Named(NAMED_PUNCH_REPOSITORY_MOCK)
    abstract fun bindPunchRepositoryMock(repository: PunchRepositoryMock): PunchRepository

    @Binds
    @Singleton
    @Named(NAMED_STATISTICS_REPOSITORY_REAL)
    abstract fun bindStatisticsRepository(repository: StatisticsRepositoryImpl): StatisticsRepository

    @Binds
    @Singleton
    @Named(NAMED_STATISTICS_REPOSITORY_MOCK)
    abstract fun bindStatisticsRepositoryMock(repository: StatisticsRepositoryMock): StatisticsRepository
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
