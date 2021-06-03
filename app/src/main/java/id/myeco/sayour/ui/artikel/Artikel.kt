package id.myeco.sayour.ui.artikel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.myeco.sayour.R
import id.myeco.sayour.adapter.ArtikelAdapter
import id.myeco.sayour.adapter.KatalogAdapter
import id.myeco.sayour.model.ArtikelResponse
import id.myeco.sayour.model.KatalogResponse
import id.myeco.sayour.ui.katalog.DetailKatalog
import id.myeco.sayour.ui.katalog.Katalog
import id.myeco.sayour.viewmodel.ArtikelViewModel
import kotlinx.android.synthetic.main.activity_artikel.*


class Artikel : AppCompatActivity() {

    companion object {
        const val KEY_ARTIKEL = "key_artikel"
    }

    private val getArtikel: Observer<List<ArtikelResponse.ArtikelModel>> =
        object : Observer<List<ArtikelResponse.ArtikelModel>> {
            override fun onChanged(t: List<ArtikelResponse.ArtikelModel>?) {
                if (t != null) {
                    if(t.size != 0) {
                        showRecyclerView(t as ArrayList<ArtikelResponse.ArtikelModel>)
                        pbArtikel.visibility = View.GONE
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        pbArtikel.visibility = View.VISIBLE

        val artikelViewModel: ArtikelViewModel = ViewModelProvider(this).get(ArtikelViewModel::class.java)
        artikelViewModel.getListArtikel().observe(this, getArtikel)
        artikelViewModel.setListArtikel()

    }

    private fun showRecyclerView(list: ArrayList<ArtikelResponse.ArtikelModel>) {
        recyclerView?.layoutManager = LinearLayoutManager(this)
        val adapter = ArtikelAdapter(list)
        adapter.notifyDataSetChanged()
        recyclerView?.adapter = adapter
        adapter.setOnItemClickCallBack(object : ArtikelAdapter.OnItemClickCallBack{
            override fun onItemClicked(data: ArtikelResponse.ArtikelModel) {
                val intent = Intent(this@Artikel, DetailArtikel::class.java)
                intent.putExtra(KEY_ARTIKEL, data.judul_url)
                startActivity(intent)
            }
        })
    }
}