package cl.sulcansystem.superheroes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cl.sulcansystem.superheroes.model.HeroMini
@Dao
interface HeroeDao {

    @Query("SELECT * FROM hero_table")
    fun getAllHeroes() : LiveData<List<HeroeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(heroeList : List<HeroeEntity>)

    @Query("SELECT id, name, images_sm FROM hero_table")
    fun getMinimalHeroes() : LiveData<List<HeroMini>>

    @Query("SELECT * FROM hero_table WHERE id = :id")
    fun getHeroe(id: Int) : LiveData<HeroeEntity>
}
