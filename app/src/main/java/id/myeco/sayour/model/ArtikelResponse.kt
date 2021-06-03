package id.myeco.sayour.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArtikelResponse {
    @SerializedName("status")
    @Expose
    private val status:String = ""
    fun getStatus():String {
        return status
    }

    @SerializedName("msg")
    @Expose
    private val msg:String = ""
    fun getMSg(): String {
        return msg
    }

    @SerializedName("artikel")
    @Expose
    private val list: List<ArtikelModel>? = null
    fun getListArtikel() : List<ArtikelModel>? {
        return list
    }

    data class ArtikelModel(
        val judul_url:String,
        val judul:String,
        val desc:String,
        val img:String,
        val time:String
    )
}