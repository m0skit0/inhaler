package org.m0skit0.android.inhaler.domain.history

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.m0skit0.android.inhaler.data.PunchRepository
import org.m0skit0.android.inhaler.domain.Punch
import org.m0skit0.android.inhaler.domain.toPunch
import javax.inject.Inject

class PunchHistoryInteractorImpl
@Inject constructor(
    private val repository: PunchRepository
): PunchHistoryInteractor {
    override suspend fun history(): Flow<List<Punch>> = repository.allPunches().map { list -> list.map { it.toPunch() } }
}
