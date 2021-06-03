package id.myeco.sayour.ui.katalog

import android.R.id.message
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.myeco.sayour.R
import id.myeco.sayour.model.KatalogResponse
import id.myeco.sayour.ui.Profil
import id.myeco.sayour.ui.katalog.Katalog.Companion.KEY_KATALOG
import kotlinx.android.synthetic.main.activity_detail_katalog.*


class DetailKatalog : AppCompatActivity() {
    companion object {
        const val KEY_NAMA = "key_nama"
        const val KEY_WA = "key_wa"
        const val KEY_IMAGE = "key_image"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_katalog)

        val data = intent.getParcelableExtra<KatalogResponse.KatalogModel>(KEY_KATALOG)
        if(data!=null) {
            Glide.with(this)
                .load(data.foto)
                .into(imageViewDetailKatalog)
            harga.text = "${data.harga}/ ${data.satuan}"
            namaProduk.text = data.nama
            keterangan.text = data.deskripsi
        }

        btnProfilToko.setOnClickListener {
            val intent = Intent(this, Profil::class.java)
            intent.putExtra(KEY_NAMA, data?.nama_penjual)
            intent.putExtra(KEY_WA, data?.no_wa)
            intent.putExtra(KEY_IMAGE, data?.foto_profil)
            startActivity(intent)
        }

        btnKirimPesan.setOnClickListener {
            openWhatsApp(data?.no_wa, data?.nama)
        }
    }

    private fun openWhatsApp(nomor: String?, namaProduk: String?) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(
                        java.lang.String.format(
                            "https://api.whatsapp.com/send?phone=%s&text=%s",
                            nomor,
                            "Saya mau bertanya tentang produk ${namaProduk}"
                        )
                    )
                )
            )
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}