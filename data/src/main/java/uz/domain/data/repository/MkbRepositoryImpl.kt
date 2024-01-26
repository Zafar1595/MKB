package uz.domain.data.repository

import uz.domain.data.dao.MkbDao
import uz.domain.domain.entity.MkbEntity
import uz.domain.data.models.mapper.toEntity
import uz.domain.domain.repository.IMkbRepository

class MkbRepositoryImpl(private val dao: MkbDao) : IMkbRepository {

    override suspend fun getAllMkb(): List<MkbEntity> = dao.getAllMkb().map { it.toEntity() }

    override suspend fun getMkbByDiagnosisName(diagnosisName: String): MkbEntity = dao.getMkbByDiagnosisName(diagnosisName).toEntity()

    override suspend fun getMkbByDiagnosisNum(diagnosisNum: String): MkbEntity = dao.getMkbByDiagnosisNum(diagnosisNum).toEntity()

}