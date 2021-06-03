package id.myeco.sayour.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.myeco.sayour.api.ApiInterface
import id.myeco.sayour.api.ApiRepository
import id.myeco.sayour.model.KatalogResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KatalogViewModel: ViewModel() {
    private val list: MutableLiveData<List<KatalogResponse.KatalogModel>> = MutableLiveData()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(ApiRepository.URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val serviceApi: ApiInterface = retrofit.create(ApiInterface::class.java)

    fun setListKatalog() {
        val movieObjectCall: Call<KatalogResponse> = serviceApi.getKatalog()
        movieObjectCall.enqueue(object : Callback<KatalogResponse> {
            override fun onResponse(
                call: Call<KatalogResponse>,
                response: Response<KatalogResponse>
            ) {
                if (response.isSuccessful) {
                    list.value = response.body()?.getListKatalog()
                    Log.d("berhasil", "data ${response.body()?.getListKatalog()?.size}")
                } else {
                    Log.d("error", "data ${response.message()}")
                }
            }

            override fun onFailure(
                call: Call<KatalogResponse>,
                t: Throwable
            ) {
                Log.w("Response Failure", t.message!!)
            }
        })
    }

    fun getListKatalog(): LiveData<List<KatalogResponse.KatalogModel>> {
        return list
    }
}