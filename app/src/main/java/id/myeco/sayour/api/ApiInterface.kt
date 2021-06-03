package id.myeco.sayour.api

import id.myeco.sayour.model.ArtikelResponse
import id.myeco.sayour.model.KatalogResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {
    @GET("katalog")
    fun getKatalog() : Call<KatalogResponse>

    @GET("artikel.json")
    fun getArtikel() : Call<ArtikelResponse>
}