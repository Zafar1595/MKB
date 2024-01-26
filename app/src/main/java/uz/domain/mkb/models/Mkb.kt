package uz.domain.mkb.models

data class Mkb(
    val diagnosis_Num: String,
    val diagnosis_Name: String,
    val diagnosis_Name_Uz: String
){
    override fun toString(): String {
        return "Mkb(diagnosis_Num='$diagnosis_Num', diagnosis_Name='$diagnosis_Name', diagnosis_Name_Uz='$diagnosis_Name_Uz')"
    }
}
