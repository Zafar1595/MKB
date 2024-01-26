package uz.domain.domain.usecase

import uz.domain.domain.repository.IMkbRepository

class GetMkbByDiagnosisNameUseCase(private val repository: IMkbRepository) {

    suspend operator fun invoke(name: String) =
        repository.getMkbByDiagnosisName(diagnosisName = name)

}