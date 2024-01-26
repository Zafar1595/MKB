package uz.domain.domain.usecase

import uz.domain.domain.repository.IMkbRepository

class GetMkbByDiagnosisNumUseCase(private val repository: IMkbRepository) {

    suspend operator fun invoke(num: String) = repository.getMkbByDiagnosisNum(diagnosisNum = num)

}