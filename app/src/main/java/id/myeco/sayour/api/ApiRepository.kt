package id.myeco.sayour.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {
    const val URL = "http://192.168.43.214/sayour-api/public/api/"
    const val BASE_URL = "http://192.168.43.214/sayour-api/public/"
//    fun create(): ApiInterface {
//        val retrofit = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(URL)
//            .build()
//        return retrofit.create(ApiInterface::class.java)
//    }
}