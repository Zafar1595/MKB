package uz.domain.domain.usecase

import uz.domain.domain.repository.IMkbRepository

class GetAllMkbUseCase(private val repository: IMkbRepository) {

    suspend operator fun invoke() = repository.getAllMkb()

}