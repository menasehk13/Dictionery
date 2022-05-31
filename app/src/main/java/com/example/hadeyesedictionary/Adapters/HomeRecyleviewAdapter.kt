package com.example.hadeyesedictionary.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hadeyesedictionary.Model.HomeData
import com.example.hadeyesedictionary.R

class HomeRecyleviewAdapter(val list:List<HomeData>):RecyclerView.Adapter<HomeRecyleviewAdapter.viewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyleviewAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_class_home,parent,false)
        return  viewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeRecyleviewAdapter.viewHolder, position: Int) {
        holder.nameview.text = list[position].name
        holder.disc.text = list[position].discription
    }

    override fun getItemCount(): Int {
       return list.size
    }


    class viewHolder(view: View):RecyclerView.ViewHolder(view) {
            val nameview = view.findViewById<TextView>(R.id.name)
            val disc = view.findViewById<TextView>(R.id.disc)
    }
}