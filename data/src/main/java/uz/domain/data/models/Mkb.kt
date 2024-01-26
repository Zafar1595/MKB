package uz.domain.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "No_Name")
data class Mkb(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "Diagnosis_Num")
    val Diagnosis_Num: String,
    @ColumnInfo(name = "Diagnosis_Name")
    val Diagnosis_Name: String,
    @ColumnInfo(name = "Diagnosis_Name_Uz")
    val Diagnosis_Name_Uz: String
)