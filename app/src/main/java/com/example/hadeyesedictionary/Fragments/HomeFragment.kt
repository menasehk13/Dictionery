package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hadeyesedictionary.Adapters.HomeRecyleviewAdapter
import com.example.hadeyesedictionary.Model.HomeData
import com.example.hadeyesedictionary.R


class HomeFragment : Fragment() {
        lateinit var homeRecyleviewAdapter: HomeRecyleviewAdapter
        lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.home_recyle)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView.hasFixedSize()
        homeRecyleviewAdapter = HomeRecyleviewAdapter(fakeData())
        recyclerView.adapter=homeRecyleviewAdapter
    }
    private fun fakeData():ArrayList<HomeData>{
        val Data = ArrayList<HomeData>()
        Data.add(HomeData("test","discriptionTest","meaning test"))
        Data.add(HomeData("test2","discriptionTest","meaning test"))
        Data.add(HomeData("test","discriptionTest","meaning test"))
        Data.add(HomeData("test","discriptionTest","meaning test"))
        Data.add(HomeData("test","discriptionTest","meaning test"))
        Data.add(HomeData("test","discriptionTest","meaning test"))
        Data.add(HomeData("test","discriptionTest","meaning test"))
        Data.add(HomeData("test","discriptionTest","meaning test"))

        return Data
    }

    companion object {

    }
}