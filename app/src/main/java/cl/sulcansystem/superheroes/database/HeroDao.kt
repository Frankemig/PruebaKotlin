package cl.sulcansystem.superheroes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.sulcansystem.superheroes.model.HeroMini
@Dao
interface HeroDao {
    //guarda y recupera informacion desde la entidad
    @Query("SELECT * FROM hero_table")
    fun getAllHeroes() : LiveData<List<HeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroList : List<HeroEntity>)
    //fun insertHero(hero : HeroEntity)

    @Query("SELECT id, name, images_sm FROM hero_table")
    fun getMinimalHeroes() : LiveData<List<HeroMini>>
}