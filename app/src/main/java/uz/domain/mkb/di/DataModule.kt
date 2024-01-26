package uz.domain.mkb.di

import androidx.room.Room
import org.koin.dsl.module
import uz.domain.data.dao.MkbDao
import uz.domain.data.db.MkbDatabase

val dataModule = module {

    single<MkbDatabase> {
        Room.databaseBuilder(
            context = get(),
            klass = MkbDatabase::class.java,
            name = "qwe.db"
        )
            .createFromAsset("qwe.db")
            .build()
    }

    factory<MkbDao> {
        get<MkbDatabase>().mkbDao()
    }


}