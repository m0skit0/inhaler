package org.m0skit0.android.inhaler.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.m0skit0.android.inhaler.domain.PunchInteractor
import org.m0skit0.android.inhaler.domain.PunchInteractorImpl

@Module
@InstallIn(ApplicationComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindPunchInteractor(repository: PunchInteractorImpl): PunchInteractor
}