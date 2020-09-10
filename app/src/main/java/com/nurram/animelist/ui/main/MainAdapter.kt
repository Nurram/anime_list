package com.nurram.animelist.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.nurram.animelist.R
import com.nurram.animelist.data.model.Animes
import com.nurram.animelist.databinding.ItemListBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private val items = arrayListOf<Animes.Anime>()

    class MainHolder(private val dataBinding: ItemListBinding): RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(anime: Animes.Anime) {
            dataBinding.model = anime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainHolder(DataBindingUtil.inflate(inflater, R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size

    fun setData(items: ArrayList<Animes.Anime>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}