package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hadeyesedictionary.Adapters.FavoriteRecycleviewAdapter
import com.example.hadeyesedictionary.Helper.SharedLoad
import com.example.hadeyesedictionary.Helper.Sharedpref
import com.example.hadeyesedictionary.Model.HomeData
import com.example.hadeyesedictionary.R


class FavoriteFragment : Fragment() {
 lateinit var recyclerView: RecyclerView
 lateinit var favoriteRecycleviewAdapter: FavoriteRecycleviewAdapter
//  var favData:ArrayList<HomeData> = ArrayList<HomeData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        val sharedpref=SharedLoad(requireContext())
        if (sharedpref.loadData()!= null){

            favoriteRecycleviewAdapter = FavoriteRecycleviewAdapter(requireContext(),
                sharedpref.loadData()!!
            )
            recyclerView.adapter = favoriteRecycleviewAdapter
        }

    }

    private fun initView(view: View) {
        recyclerView = view.findViewById(R.id.recyle_fav)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

    companion object {
    }
}