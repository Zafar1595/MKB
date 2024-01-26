package uz.domain.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.domain.data.dao.MkbDao
import uz.domain.data.models.Mkb

@Database(version = 1, entities = [Mkb::class])
abstract class MkbDatabase : RoomDatabase() {

    abstract fun mkbDao(): MkbDao

}