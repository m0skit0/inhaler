package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import org.joda.time.DateTime

interface PunchesByDayInteractor {
    fun punchesByDay(): Flow<Map<DateTime, Int>>
}
