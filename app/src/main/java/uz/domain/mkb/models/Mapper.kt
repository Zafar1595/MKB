package uz.domain.mkb.models

import uz.domain.domain.entity.MkbEntity

fun MkbEntity.toAppModel() = Mkb(
    diagnosis_Num = diagnosis_Num,
    diagnosis_Name = diagnosis_Name,
    diagnosis_Name_Uz = diagnosis_Name_Uz
)