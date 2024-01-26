package uz.domain.mkb.di

import org.koin.dsl.module
import uz.domain.domain.repository.IMkbRepository
import uz.domain.data.repository.MkbRepositoryImpl
import uz.domain.domain.usecase.GetAllMkbUseCase
import uz.domain.domain.usecase.GetMkbByDiagnosisNameUseCase
import uz.domain.domain.usecase.GetMkbByDiagnosisNumUseCase

val domainModule = module {

    factory<GetAllMkbUseCase> {
        GetAllMkbUseCase(repository = get())
    }

    factory<GetMkbByDiagnosisNameUseCase> {
        GetMkbByDiagnosisNameUseCase(repository = get())
    }

    factory<GetMkbByDiagnosisNumUseCase> {
        GetMkbByDiagnosisNumUseCase(repository = get())
    }

    factory<IMkbRepository> {
        MkbRepositoryImpl(dao = get())
    }

}