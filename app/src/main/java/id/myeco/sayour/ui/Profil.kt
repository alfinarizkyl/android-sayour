package id.myeco.sayour.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.bumptech.glide.Glide
import id.myeco.sayour.R
import id.myeco.sayour.ui.katalog.DetailKatalog.Companion.KEY_IMAGE
import id.myeco.sayour.ui.katalog.DetailKatalog.Companion.KEY_NAMA
import id.myeco.sayour.ui.katalog.DetailKatalog.Companion.KEY_WA
import kotlinx.android.synthetic.main.activity_profil.*

class Profil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val foto = intent.getStringExtra(KEY_IMAGE)
        val penjual = intent.getStringExtra(KEY_NAMA)
        val noWA = intent.getStringExtra(KEY_WA)

        Glide.with(this)
            .load(foto)
            .into(imageViewProfil)
        tvNama.text = penjual
        tvKontak.text = noWA
    }
}