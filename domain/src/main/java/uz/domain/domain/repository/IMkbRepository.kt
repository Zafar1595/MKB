package uz.domain.domain.repository

import uz.domain.domain.entity.MkbEntity

interface IMkbRepository {

    suspend fun getAllMkb(): List<MkbEntity>

    suspend fun getMkbByDiagnosisName(diagnosisName: String): MkbEntity

    suspend fun getMkbByDiagnosisNum(diagnosisNum: String): MkbEntity

}