package org.m0skit0.android.inhaler.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractor
import org.m0skit0.android.inhaler.domain.history.PunchHistoryInteractorImpl
import org.m0skit0.android.inhaler.domain.punch.PunchInteractor
import org.m0skit0.android.inhaler.domain.punch.PunchInteractorImpl
import org.m0skit0.android.inhaler.domain.stats.PunchStatisticsInteractor
import org.m0skit0.android.inhaler.domain.stats.PunchStatisticsInteractorImpl
import org.m0skit0.android.inhaler.domain.stats.PunchesByDayInteractor
import org.m0skit0.android.inhaler.domain.stats.PunchesByDayInteractorImpl
import javax.inject.Singleton

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
    abstract fun bindPunchStatisticsInteractor(interactor: PunchStatisticsInteractorImpl): PunchStatisticsInteractor

    @Binds
    @Singleton
    abstract fun bindPunchesByDay(interactor: PunchesByDayInteractorImpl): PunchesByDayInteractor
}
