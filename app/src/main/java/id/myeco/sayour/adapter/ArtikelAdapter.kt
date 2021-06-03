package id.myeco.sayour.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.myeco.sayour.R
import id.myeco.sayour.model.ArtikelResponse
import id.myeco.sayour.model.KatalogResponse
import kotlinx.android.synthetic.main.card_layoutartikel.view.*

class ArtikelAdapter(private val list: ArrayList<ArtikelResponse.ArtikelModel>) : RecyclerView.Adapter<ArtikelAdapter.ListViewHolder>() {

    private var onItemClickCallBack: ArtikelAdapter.OnItemClickCallBack? = null

    fun setOnItemClickCallBack(onItemClickCallBack: ArtikelAdapter.OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtikelAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layoutartikel, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtikelAdapter.ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(model: ArtikelResponse.ArtikelModel) {
            with(itemView) {
                item_title.text = model.judul
                Item_Jam.text = model.time
                Glide.with(context)
                    .load(model.img)
                    .into(item_image)
                itemView.setOnClickListener { onItemClickCallBack?.onItemClicked(model) }
            }
        }
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickCallBack {
        fun onItemClicked(data: ArtikelResponse.ArtikelModel)
    }
}