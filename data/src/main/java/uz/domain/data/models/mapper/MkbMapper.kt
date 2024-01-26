package uz.domain.data.models.mapper

import uz.domain.domain.entity.MkbEntity
import uz.domain.data.models.Mkb

fun Mkb.toEntity() = MkbEntity(
    diagnosis_Num = Diagnosis_Num,
    diagnosis_Name = Diagnosis_Name,
    diagnosis_Name_Uz = Diagnosis_Name_Uz
)