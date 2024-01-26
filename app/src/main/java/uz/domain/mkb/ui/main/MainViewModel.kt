package uz.domain.mkb.ui.main

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import uz.domain.mkb.models.Mkb
import uz.domain.mkb.models.toAppModel
import uz.domain.domain.usecase.GetAllMkbUseCase

class MainViewModel(private val getAllMkbUseCase: GetAllMkbUseCase) : ViewModel() {
    private var job: Job? = null


    override fun onCleared() {
        super.onCleared()

        if (job != null) {
            job = null
        }
    }

    var textSize: MutableLiveData<Int> = MutableLiveData()


    val mkbList: MutableLiveData<List<Mkb>> = MutableLiveData()

    fun getAllMkb() {
        job = viewModelScope.launch {
            mkbList.value = getAllMkbUseCase().map { it.toAppModel() }
            Log.d("checkData", "getAllMkb: ${mkbList.value}")
        }
    }

    fun searchMkb(query: String) {
        job = viewModelScope.launch {
            mkbList.value = getAllMkbUseCase().map { it.toAppModel() }.filter {
                it.diagnosis_Name.lowercase().contains(query.lowercase()) ||
                        it.diagnosis_Num.lowercase().contains(query.lowercase()) ||
                        it.diagnosis_Name_Uz.lowercase().contains(query.lowercase())
            }
        }
    }

}