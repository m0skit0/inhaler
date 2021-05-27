package org.m0skit0.android.inhaler.data.inhaler

interface InhalerRepository {
    suspend fun current(): InhalerData
    suspend fun all(): List<InhalerData>
    suspend fun punchesForCurrent(): Int
    suspend fun punchesFor(inhaler: InhalerData): Int
}
