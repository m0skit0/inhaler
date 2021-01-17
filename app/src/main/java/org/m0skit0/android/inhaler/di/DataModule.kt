package org.m0skit0.android.inhaler.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.m0skit0.android.inhaler.data.PunchRepository
import org.m0skit0.android.inhaler.data.PunchRepositoryImpl

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindPunchRepository(repository: PunchRepositoryImpl): PunchRepository
}