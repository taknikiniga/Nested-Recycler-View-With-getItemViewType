package com.taknikinigga.nestedrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.group_layout.view.*


class GroupAdapter(val groupList: List<ItemGroup>) :
    RecyclerView.Adapter<GroupAdapter.GroupAdapterViewHolder>() {

    companion object {
        private const val HORIZONTAL = 0
        private const val VERTICAL = 1

    }

    inner class GroupAdapterViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.group_layout, parent, false)
        return GroupAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupAdapterViewHolder, position: Int) {

        val itemList = groupList[position].ItemList
        val orientation = groupList[position].orientation
        holder.itemView.apply {
            txt_ttitle.text = groupList[position].title
            val adapter = ItemAdapter(itemList)
            child_recyclerview.adapter = adapter

            if (orientation == HORIZONTAL) {
                child_recyclerview.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
            if (orientation == VERTICAL) {
                child_recyclerview.layoutManager =
                    GridLayoutManager(context, 1, GridLayoutManager.VERTICAL, false)
            }

            adapter.notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}
