package org.m0skit0.android.inhaler.domain.history

import org.m0skit0.android.inhaler.data.PunchRepository
import org.m0skit0.android.inhaler.domain.Punch
import org.m0skit0.android.inhaler.domain.toPunch
import javax.inject.Inject

class PunchHistoryInteractorImpl
@Inject constructor(
    private val repository: PunchRepository
): PunchHistoryInteractor {
    override suspend fun history(): List<Punch> = repository.allPunches().map { it.toPunch() }
}