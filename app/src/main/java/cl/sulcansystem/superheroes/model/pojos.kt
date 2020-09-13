package cl.sulcansystem.superheroes.model

data class Hero (
    val id: Int,
    val name: String,
    val powerstats: Powerstats,
    val slug: String,
    val images : HeroImages,
    val appearance: Appearance,
    val biography: Biography
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
data class Appearance(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)
data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String
)