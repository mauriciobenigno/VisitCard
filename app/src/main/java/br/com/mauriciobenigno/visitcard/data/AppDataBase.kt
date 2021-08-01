package br.com.mauriciobenigno.visitcard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CartaoVisita::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun ctVisitaDao(): CartaoVisitaDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "cartaovisista_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}