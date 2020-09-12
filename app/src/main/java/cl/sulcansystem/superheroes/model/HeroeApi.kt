package cl.sulcansystem.superheroes.model

import retrofit2.Call
import retrofit2.http.GET

interface HeroeApi {
    @GET("all.json")
    fun allHeroes() : Call<List<Hero>>
}