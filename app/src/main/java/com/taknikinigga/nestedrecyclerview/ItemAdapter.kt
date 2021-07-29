package com.taknikinigga.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.ads_layout.view.*
import kotlinx.android.synthetic.main.layout_item.view.*

class ItemAdapter(val itemAdapterData: List<ItemData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {

        private const val REGULARPOST = 0
        private const val ADSPOST = 1

    }

    class PostViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(postModel: ItemData) {
            val image = postModel.image
            itemView.apply {
                item_one_name.text = postModel.name
                item_one_image.setImageResource(image)
            }

        }
    }

    class AdsViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(postModel: ItemData) {
            val image = postModel.image
            itemView.ads_image.setImageResource(image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == REGULARPOST) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
            PostViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.ads_layout, parent, false)
            AdsViewHolder(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (getItemViewType(position) == REGULARPOST) {
            (holder as PostViewHolder).bind(itemAdapterData[position])
        } else {
            (holder as AdsViewHolder).bind(itemAdapterData[position])
        }

    }

    override fun getItemCount(): Int {
        return itemAdapterData.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemAdapterData[position].viewType == 0) {
            REGULARPOST
        } else {
            ADSPOST
        }
    }
}
