package cl.sulcansystem.superheroes.model

data class Hero (
    val id: Int,
    val name: String,
    val powerstats: Powerstats,
    val slug: String,
    val images : HeroImages
)

data class HeroImages (
    val xs : String,
    val sm : String,
    val md : String,
    val lg : String
)

data class HeroMini (
    val id: Int,
    val name: String,
    val images_sm : String
)

data class Powerstats (
    val combat: Int,
    val durability: Int,
    val intelligence: Int,
    val power: Int,
    val speed: Int,
    val strength: Int
)