package org.m0skit0.android.inhaler.domain

import org.m0skit0.android.inhaler.data.PunchRepository
import javax.inject.Inject

class PunchInteractorImpl
@Inject constructor(
        private val repository: PunchRepository
) : PunchInteractor {
    override suspend fun punch(punch: Punch) {
        repository.storePunch(punch.toEntity())
    }
}