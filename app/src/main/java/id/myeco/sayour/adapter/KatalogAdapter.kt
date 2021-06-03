package id.myeco.sayour.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.myeco.sayour.R
import id.myeco.sayour.model.KatalogResponse
import kotlinx.android.synthetic.main.card_layout.view.*

class KatalogAdapter(private val list: ArrayList<KatalogResponse.KatalogModel>) : RecyclerView.Adapter<KatalogAdapter.ListViewHolder>() {

    private var onItemClickCallBack: OnItemClickCallBack? = null

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KatalogAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: KatalogAdapter.ListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(model: KatalogResponse.KatalogModel) {
            with(itemView) {
                item_title.text = model.nama
                Glide.with(context)
                    .load(model.foto)
                    .into(item_image)
                itemView.setOnClickListener { onItemClickCallBack?.onItemClicked(model) }
            }
        }
    }

    interface OnItemClickCallBack {
        fun onItemClicked(data: KatalogResponse.KatalogModel)
    }
}