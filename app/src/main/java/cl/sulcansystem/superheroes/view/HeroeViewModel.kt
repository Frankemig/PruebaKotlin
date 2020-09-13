package cl.sulcansystem.superheroes.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.sulcansystem.superheroes.database.HeroeEntity
import cl.sulcansystem.superheroes.model.Repository

class HeroeViewModel(application: Application) : AndroidViewModel(application) {

    private var repository : Repository = Repository(application)
    var listHero = repository.heroList

    init {
        repository = Repository(application)

        repository.loadApiData()

    }
    fun getDetails(param1: String): LiveData<HeroeEntity> {
        return repository.getDetails(param1)
    }
}