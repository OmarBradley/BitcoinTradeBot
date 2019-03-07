package omarbradley.com.gopax.domain.module

import omarbradley.com.gopax.domain.usecase.AuthKeyLoginUseCase
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val gopaxDomainModule = module {

    single { (apiKey: String, secretKey: String) ->
        AuthKeyLoginUseCase(get { parametersOf(apiKey, secretKey) })
    }
}
