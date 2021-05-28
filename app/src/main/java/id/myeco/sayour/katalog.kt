package id.myeco.sayour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class katalog : AppCompatActivity() {


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_katalog)

        layoutManager = LinearLayoutManager(this)

//        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
//        recyclerView.adapter=adapter

    }
}