package id.myeco.sayour.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.myeco.sayour.api.ApiInterface
import id.myeco.sayour.api.ApiRepository
import id.myeco.sayour.model.ArtikelResponse
import id.myeco.sayour.model.KatalogResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArtikelViewModel: ViewModel() {
    private val list: MutableLiveData<List<ArtikelResponse.ArtikelModel>> = MutableLiveData()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(ApiRepository.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val serviceApi: ApiInterface = retrofit.create(ApiInterface::class.java)

    fun setListArtikel() {
        val movieObjectCall: Call<ArtikelResponse> = serviceApi.getArtikel()
        movieObjectCall.enqueue(object : Callback<ArtikelResponse> {
            override fun onResponse(
                call: Call<ArtikelResponse>,
                response: Response<ArtikelResponse>
            ) {
                if (response.isSuccessful) {
                    list.value = response.body()?.getListArtikel()
                    Log.d("berhasil", "data ${response.body()?.getListArtikel()?.size}")
                } else {
                    Log.d("error", "data ${response.message()}")
                }
            }

            override fun onFailure(
                call: Call<ArtikelResponse>,
                t: Throwable
            ) {
                Log.w("Response Failure", t.message!!)
            }
        })
    }

    fun getListArtikel(): LiveData<List<ArtikelResponse.ArtikelModel>> {
        return list
    }
}