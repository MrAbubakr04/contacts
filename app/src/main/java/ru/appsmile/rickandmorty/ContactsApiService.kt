package ru.appsmile.rickandmorty

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("api/")
    fun getCharacter(@Query("results") count: Int = 20): Call<Item>
}

data class Item(
    val results: List<ResultItem>
)

data class ResultItem(
    @SerializedName("gender")
    val gender:String,
    @SerializedName("name")
    val name: Name,
    @SerializedName("email")
    val email:String,
    @SerializedName("phone")
    val phone:String,
    @SerializedName("picture")
    val picture: Picture
)

data class Name(
    @SerializedName("title")
    val title:String,
    @SerializedName("first")
    val first:String,
    @SerializedName("last")
    val last:String
)
data class Picture(
    @SerializedName("large")
    val large:String
)