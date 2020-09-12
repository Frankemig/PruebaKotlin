package cl.sulcansystem.superheroes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HeroeEntity::class], version = 1)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun getHeroDao() : HeroeDao

    companion object {
        // Singleton
        @Volatile
        private var INSTANCE: HeroDatabase? = null

        fun getDatabase(context: Context): HeroDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroDatabase::class.java,
                    "hero_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}