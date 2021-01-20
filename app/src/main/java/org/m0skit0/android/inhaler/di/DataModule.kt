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
import org.m0skit0.android.inhaler.data.room.InhalerDatabase
import org.m0skit0.android.inhaler.data.stats.StatisticsRepository
import org.m0skit0.android.inhaler.data.stats.StatisticsRepositoryImpl
import org.m0skit0.android.inhaler.data.stats.StatisticsRepositoryMock
import javax.inject.Named
import javax.inject.Singleton

const val NAMED_REAL_STATISTICS_REPOSITORY = "NAMED_DATABASE_REPOSITORY"
const val NAMED_MOCK_STATISTICS_REPOSITORY = "NAMED_MOCK_REPOSITORY"

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModuleBind {

    @Binds
    @Singleton
    abstract fun bindPunchRepository(repository: PunchRepositoryImpl): PunchRepository

    @Binds
    @Singleton
    @Named(NAMED_REAL_STATISTICS_REPOSITORY)
    abstract fun bindStatisticsRepository(repository: StatisticsRepositoryImpl): StatisticsRepository

    @Binds
    @Singleton
    @Named(NAMED_MOCK_STATISTICS_REPOSITORY)
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
