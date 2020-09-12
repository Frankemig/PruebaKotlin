package cl.sulcansystem.superheroes.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import cl.sulcansystem.superheroes.model.Repository

class HeroViewModel(application: Application) : AndroidViewModel(application) {

    private var repository : Repository = Repository(application)
    var listHero = repository.heroList

    init {
        repository = Repository(application)

        repository.loadApiData()

    }
}