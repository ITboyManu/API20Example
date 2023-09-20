package com.example.api20example

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(private var context: Context,private var productArrayList: List<Product>):RecyclerView.Adapter<MyAdapter.viewholder>() {
    class viewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var textview:TextView
        var imageview:ShapeableImageView
        init {
            textview=itemView.findViewById(R.id.textview1)
            imageview=itemView.findViewById(R.id.imageview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return  productArrayList.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var currentitem=productArrayList[position]
        holder.textview.text=currentitem.title
        Picasso.get().load(currentitem.thumbnail).into(holder.imageview);
    }
}