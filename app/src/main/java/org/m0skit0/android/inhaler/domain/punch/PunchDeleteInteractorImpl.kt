package org.m0skit0.android.inhaler.domain.punch

import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.punch.PunchRepository
import org.m0skit0.android.inhaler.domain.model.Punch
import org.m0skit0.android.inhaler.domain.model.toData
import javax.inject.Inject
import javax.inject.Named

class PunchDeleteInteractorImpl
@Inject constructor(
    @Named(BuildConfig.NAMED_PUNCH_REPOSITORY)
    private val repository: PunchRepository
) : PunchDeleteInteractor {
    override suspend fun delete(punch: Punch) {
        repository.delete(punch.toData())
    }
}
