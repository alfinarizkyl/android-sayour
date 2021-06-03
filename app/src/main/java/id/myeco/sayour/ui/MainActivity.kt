package id.myeco.sayour.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.myeco.sayour.R
import id.myeco.sayour.ui.artikel.Artikel
import id.myeco.sayour.ui.katalog.Katalog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnKatalog.setOnClickListener {
            val intent = Intent(this, Katalog::class.java)
            startActivity(intent)
        }

        btnArtikel.setOnClickListener {
            val intent = Intent(this, Artikel::class.java)
            startActivity(intent)
        }
    }
}