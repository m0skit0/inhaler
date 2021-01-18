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

@Module
@InstallIn(ApplicationComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindPunchInteractor(interactor: PunchInteractorImpl): PunchInteractor

    @Binds
    abstract fun bindPunchHistoryInteractor(interactor: PunchHistoryInteractorImpl): PunchHistoryInteractor

    @Binds
    abstract fun bindPunchDailyAverageInteractor(interactor: PunchDailyAverageInteractorImpl): PunchStatisticsInteractor

    @Binds
    abstract fun bindPunchDailyMaximumInteractor(interactor: PunchDailyMaximumInteractorImpl): PunchDailyMaximumInteractor

    @Binds
    abstract fun bindPunchMonthlyAverageInteractor(interactor: PunchMonthlyAverageInteractorImpl): PunchMonthlyAverageInteractor

    @Binds
    abstract fun bindPunchTotalInteractor(interactor: PunchTotalInteractorImpl): PunchTotalInteractor
}
