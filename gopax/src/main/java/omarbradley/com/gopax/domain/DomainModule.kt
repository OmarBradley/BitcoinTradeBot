package omarbradley.com.gopax.domain

import omarbradley.com.gopax.data.repository.AuthKeyRepository
import omarbradley.com.gopax.data.repository.AuthRepository
import omarbradley.com.gopax.domain.usecase.AuthKeyLoginUseCase
import omarbradley.com.gopax.domain.usecase.ManageAuthKeyUseCase
import org.koin.dsl.module

val gopaxDomainModule = module {

    single { ManageAuthKeyUseCase(get()) }
    single { AuthKeyLoginUseCase(get() as AuthRepository, get() as AuthKeyRepository) }

}
