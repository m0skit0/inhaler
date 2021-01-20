package org.m0skit0.android.inhaler.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractor
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractorImpl
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor
import org.m0skit0.android.inhaler.domain.punch.PunchInteractorImpl
import org.m0skit0.android.inhaler.domain.stats.*
import javax.inject.Named
import javax.inject.Singleton

const val NAMED_REAL_PUNCHES_BY_DAY_INTERACTOR = "NAMED_REAL_PUNCHES_BY_DAY_INTERACTOR"
const val NAMED_MOCK_PUNCHES_BY_DAY_INTERACTOR = "NAMED_MOCK_PUNCHES_BY_DAY_INTERACTOR"

const val NAMED_REAL_STATS_INTERACTOR = "NAMED_REAL_STATS_INTERACTOR"
const val NAMED_MOCK_STATS_INTERACTOR = "NAMED_MOCK_STATS_INTERACTOR"

@Module
@InstallIn(ApplicationComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun bindPunchInteractor(interactor: PunchInteractorImpl): PunchInteractor

    @Binds
    @Singleton
    abstract fun bindPunchHistoryInteractor(interactor: PunchHistoryInteractorImpl): PunchHistoryInteractor

    @Binds
    @Singleton
    @Named(NAMED_REAL_STATS_INTERACTOR)
    abstract fun bindPunchStatisticsInteractor(interactor: PunchStatisticsInteractorImpl): PunchStatisticsInteractor

    @Binds
    @Singleton
    @Named(NAMED_MOCK_STATS_INTERACTOR)
    abstract fun bindPunchStatisticsInteractorMock(interactor: PunchStatisticsInteractorMock): PunchStatisticsInteractor

    @Binds
    @Singleton
    @Named(NAMED_REAL_PUNCHES_BY_DAY_INTERACTOR)
    abstract fun bindPunchesByDay(interactor: PunchesByDayInteractorImpl): PunchesByDayInteractor

    @Binds
    @Singleton
    @Named(NAMED_MOCK_PUNCHES_BY_DAY_INTERACTOR)
    abstract fun bindPunchesByDayMock(interactor: PunchesByDayInteractorMock): PunchesByDayInteractor
}
