package id.myeco.sayour.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class KatalogResponse {
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

    @SerializedName("data")
    @Expose
    private val list: List<KatalogModel>? = null
    fun getListKatalog() : List<KatalogModel>? {
        return list
    }

    @Parcelize
    data class KatalogModel(
        val id:Int,
        val idKontak:Int,
        val nama:String,
        val foto:String,
        val harga:Int,
        val deskripsi:String,
        val satuan:String,
        val nama_penjual:String,
        val alamat:String,
        val no_wa:String,
        val foto_profil:String
    ): Parcelable
}