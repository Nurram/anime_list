package com.nurram.animelist.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nurram.animelist.R
import com.nurram.animelist.data.model.Animes
import com.nurram.animelist.databinding.ItemListBinding


class MainAdapter: RecyclerView.Adapter<MainAdapter.MainHolder>() {
    private val items = arrayListOf<Animes.Anime>()
    lateinit var context: Context

    inner class MainHolder(private val dataBinding: ItemListBinding): RecyclerView.ViewHolder(dataBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(anime: Animes.Anime) {
            with(dataBinding) {
                model = anime

                itemVisit.setOnClickListener {
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(anime.url)
                    context.startActivity(i)
                }

                Glide.with(context).load(anime.imageUrl).into(itemImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        context = parent.context
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