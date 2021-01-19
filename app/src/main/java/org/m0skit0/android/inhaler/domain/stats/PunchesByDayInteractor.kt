package org.m0skit0.android.inhaler.domain.stats

import kotlinx.coroutines.flow.Flow
import java.util.*

interface PunchesByDayInteractor {
    fun punchesByDay(): Flow<Map<Date, Int>>
}
