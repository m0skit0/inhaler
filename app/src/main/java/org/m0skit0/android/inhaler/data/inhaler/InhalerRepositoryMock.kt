package org.m0skit0.android.inhaler.data.inhaler

class InhalerRepositoryMock : InhalerRepository {
    override suspend fun current(): InhalerData {
        TODO("Not yet implemented")
    }

    override suspend fun all(): List<InhalerData> {
        TODO("Not yet implemented")
    }

    override suspend fun punchesForCurrent(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun punchesFor(inhaler: InhalerData): Int {
        TODO("Not yet implemented")
    }
}
