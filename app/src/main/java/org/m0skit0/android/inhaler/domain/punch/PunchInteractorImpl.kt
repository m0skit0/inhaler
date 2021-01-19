package org.m0skit0.android.inhaler.domain.punch

import org.m0skit0.android.inhaler.data.punch.PunchRepository
import org.m0skit0.android.inhaler.domain.model.Punch
import org.m0skit0.android.inhaler.domain.model.toData
import javax.inject.Inject

class PunchInteractorImpl
@Inject constructor(
        private val repository: PunchRepository
) : PunchInteractor {
    override suspend fun punch(punch: Punch) {
        repository.punch(punch.toData())
    }
}
