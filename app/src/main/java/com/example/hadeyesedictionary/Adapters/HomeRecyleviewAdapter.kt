package com.example.hadeyesedictionary.Adapters

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hadeyesedictionary.Helper.Sharedpref
import com.example.hadeyesedictionary.Model.HomeData
import com.example.hadeyesedictionary.R
import java.util.*
import kotlin.collections.ArrayList

class HomeRecyleviewAdapter(var context: Context,var list:ArrayList<HomeData>):RecyclerView.Adapter<HomeRecyleviewAdapter.viewHolder>() {
  lateinit var textToSpeech: TextToSpeech
  var favList:ArrayList<HomeData> = ArrayList<HomeData>(403)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeRecyleviewAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_class_home,parent,false)
        return  viewHolder(view)
    }

    fun fliteredList(filterd:ArrayList<HomeData>){
        list = filterd

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: HomeRecyleviewAdapter.viewHolder, position: Int) {
        var listFav = ArrayList<HomeData>()
        holder.nameview.text = list[position].Haddiyisaa
        holder.disc.text = list[position].amharic
        holder.english.text = list[position].english
         textToSpeech= TextToSpeech(context,object :TextToSpeech.OnInitListener{
            override fun onInit(status: Int) {
                if (status!=TextToSpeech.ERROR){
                    textToSpeech.language = Locale.UK
                }
            }
        })
        holder.voiceButton.setOnClickListener {
            textToSpeech.speak(list[position].english ,TextToSpeech.QUEUE_FLUSH,null)
        }
        holder.favoriteButton.setOnClickListener {
            holder.favoriteButton.setImageDrawable(context.resources.getDrawable(R.drawable.ic_baseline_favorite_add_24))

            favList.add(HomeData(list[position].Haddiyisaa,list[position].amharic,list[position].english))

            Log.d("LIST CHECK", "onBindViewHolder:${favList} ")
            Sharedpref(context,favList).saveData()
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }


    class viewHolder(view: View):RecyclerView.ViewHolder(view) {
        val nameview = view.findViewById<TextView>(R.id.name)
        val disc = view.findViewById<TextView>(R.id.disc)
        val english = view.findViewById<TextView>(R.id.english)
        val voiceButton = view.findViewById<ImageButton>(R.id.voicebutton)
        val favoriteButton = view.findViewById<ImageButton>(R.id.addfavorite)
    }
}