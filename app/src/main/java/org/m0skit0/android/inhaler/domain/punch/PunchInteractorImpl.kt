package org.m0skit0.android.inhaler.domain.punch

import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.punch.PunchRepository
import javax.inject.Inject
import javax.inject.Named

class PunchInteractorImpl
@Inject constructor(
    @Named(BuildConfig.NAMED_PUNCH_REPOSITORY)
    private val repository: PunchRepository
) : PunchInteractor {

    override suspend fun punch() {
        repository.punch()
    }

    override suspend fun punch(punch: Punch) {
        repository.punch(punch.toData())
    }
}
