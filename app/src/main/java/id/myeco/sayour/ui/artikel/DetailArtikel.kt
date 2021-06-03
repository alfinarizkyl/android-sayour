package id.myeco.sayour.ui.artikel

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import id.myeco.sayour.R
import id.myeco.sayour.ui.artikel.Artikel.Companion.KEY_ARTIKEL
import kotlinx.android.synthetic.main.activity_detail_artikel.*

class DetailArtikel : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artikel)

        var url = intent.getStringExtra(KEY_ARTIKEL)
        if(url != null) {
            webViewArtikel.webViewClient = WebViewClient()
            webViewArtikel.loadUrl(url)
            webViewArtikel.settings.javaScriptEnabled = true
        }
    }
}