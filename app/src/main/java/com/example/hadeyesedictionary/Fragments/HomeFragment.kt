package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hadeyesedictionary.Adapters.HomeRecyleviewAdapter
import com.example.hadeyesedictionary.Model.HomeData
import com.example.hadeyesedictionary.R
import java.util.Locale.filter


class HomeFragment : Fragment() {
        lateinit var homeRecyleviewAdapter: HomeRecyleviewAdapter
        lateinit var recyclerView: RecyclerView
        lateinit var searchView: SearchView
        lateinit var DataRecyle:ArrayList<HomeData>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView = view.findViewById(R.id.search_view)
        recyclerView = view.findViewById(R.id.home_recyle)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView.hasFixedSize()
        homeRecyleviewAdapter = HomeRecyleviewAdapter(fakeData())
        recyclerView.adapter=homeRecyleviewAdapter
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText)
                return false
            }

        })

    }

    private fun filter(newText: String?) {
    val filteredList = ArrayList<HomeData>()

       for (items in DataRecyle){
           if (items.name.lowercase().contains(newText!!.lowercase())){
               filteredList.add(items)
           }
           if (filteredList.isEmpty()){
               Log.d("TAG", "filter: not searched yet ")
           }else{
               homeRecyleviewAdapter.fliteredList(filteredList)
           }
       }
    }

    private fun fakeData():ArrayList<HomeData>{
         DataRecyle = ArrayList<HomeData>()
        DataRecyle.add(HomeData("one","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("two","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("three","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("four","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("five","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("six","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("seven","discriptionTest","meaning test"))
        DataRecyle.add(HomeData("eight","discriptionTest","meaning test"))
        return DataRecyle
    }

    companion object {

    }
}