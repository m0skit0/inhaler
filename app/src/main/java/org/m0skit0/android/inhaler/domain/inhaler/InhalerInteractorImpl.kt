package org.m0skit0.android.inhaler.domain.inhaler

import org.m0skit0.android.inhaler.BuildConfig
import org.m0skit0.android.inhaler.data.inhaler.InhalerRepository
import javax.inject.Inject
import javax.inject.Named

class InhalerInteractorImpl
@Inject
constructor(
    @Named(BuildConfig.NAMED_INHALER_REPOSITORY)
    private val inhalerRepository: InhalerRepository
) : InhalerInteractor {

    override suspend fun current(): Inhaler = inhalerRepository.current().toInhaler()

    override suspend fun all(): List<Inhaler> = inhalerRepository.all().map { it.toInhaler() }

    override suspend fun punchesForCurrent(): Int = inhalerRepository.punchesForCurrent()

    override suspend fun punchesFor(inhaler: Inhaler): Int = inhalerRepository.punchesFor(inhaler.toData())
}
