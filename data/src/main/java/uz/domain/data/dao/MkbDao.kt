package uz.domain.data.dao

import androidx.room.Dao
import androidx.room.Query
import uz.domain.data.models.Mkb

@Dao
interface MkbDao {

    @Query("SELECT * FROM No_Name")
    suspend fun getAllMkb(): List<Mkb>

    @Query("SELECT * FROM No_Name WHERE Diagnosis_Num = :num")
    suspend fun getMkbByDiagnosisNum(num: String): Mkb

    @Query("SELECT * FROM No_Name WHERE Diagnosis_Name = :name")
    suspend fun getMkbByDiagnosisName(name: String): Mkb

}