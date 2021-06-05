package org.m0skit0.android.inhaler.domain.inhaler

interface InhalerInteractor {
    suspend fun current(): Inhaler
    suspend fun all(): List<Inhaler>
    suspend fun punchesForCurrent(): Int
    suspend fun punchesFor(inhaler: Inhaler): Int
}
