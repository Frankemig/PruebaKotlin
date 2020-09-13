package cl.sulcansystem.superheroes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HeroeEntity::class], version = 1)
abstract class HeroeDatabase : RoomDatabase() {

    abstract fun getHeroeDao() : HeroeDao

    companion object {
        // Singleton
        @Volatile
        private var INSTANCE: HeroeDatabase? = null

        fun getDatabase(context: Context): HeroeDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroeDatabase::class.java,
                    "heroe_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}