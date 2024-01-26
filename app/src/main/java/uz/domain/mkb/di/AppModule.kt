package uz.domain.mkb.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.domain.mkb.ui.main.MainViewModel

val appModule = module {

    viewModel <MainViewModel> {
        MainViewModel(getAllMkbUseCase = get())
    }

}