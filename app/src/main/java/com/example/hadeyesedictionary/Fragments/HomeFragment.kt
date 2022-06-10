package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hadeyesedictionary.Adapters.HomeRecyleviewAdapter
import com.example.hadeyesedictionary.Model.HomeData
import com.example.hadeyesedictionary.R
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


class HomeFragment : Fragment() {
        lateinit var homeRecyleviewAdapter: HomeRecyleviewAdapter
        lateinit var recyclerView: RecyclerView
        lateinit var searchView: SearchView
        lateinit var Hometogame:ImageButton
         var DataRecyle:ArrayList<HomeData> = ArrayList<HomeData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.hadeyesedictionary.R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView = view.findViewById(com.example.hadeyesedictionary.R.id.search_view)
        recyclerView = view.findViewById(com.example.hadeyesedictionary.R.id.home_recyle)
        Hometogame=view.findViewById(R.id.homeToGame)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        recyclerView.hasFixedSize()
        homeRecyleviewAdapter= HomeRecyleviewAdapter(requireContext(),DataRecyle)
        recyclerView.adapter= homeRecyleviewAdapter
        addItemsFromJSON()
        Hometogame.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }
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
    private fun addItemsFromJSON() {
        try {
            val jsonDataString = readJSONDataFromFile()
            val jsonArray = JSONArray(jsonDataString)
            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val Haddiyisaa = itemObj.getString("Haddiyisaa")
                val amharic = itemObj.getString("amharic")
                val english = itemObj.getString("english")
                val holidays = HomeData(Haddiyisaa, amharic,english)
                DataRecyle.add(holidays)
            }
        } catch (e: JSONException) {
            Log.d("TAG", "addItemsFromJSON: ", e)
        } catch (e: IOException) {
            Log.d("TAG", "addItemsFromJSON: ", e)
        }
    }


    @Throws(IOException::class)
    private fun readJSONDataFromFile(): String? {
        var inputStream: InputStream? = null
        val builder = java.lang.StringBuilder()
        try {
            var jsonString: String? = null
            inputStream = resources.openRawResource(com.example.hadeyesedictionary.R.raw.translation)
            val bufferedReader = BufferedReader(
                InputStreamReader(inputStream, "UTF-8")
            )
            while (bufferedReader.readLine().also { jsonString = it } != null) {
                builder.append(jsonString)
            }
        } finally {
            inputStream?.close()
        }
        return String(builder)
    }


    private fun filter(newText: String?) {
    val filteredList = ArrayList<HomeData>()

       for (items in DataRecyle){
           if (items.Haddiyisaa.lowercase().contains(newText!!.lowercase())){
               filteredList.add(items)
           }else if(items.amharic.contains(newText)){
               filteredList.add(items)
           }else if(items.english.lowercase().contains(newText.lowercase())){
               filteredList.add(items)
           }else if (filteredList.isEmpty()){
               Log.d("TAG", "filter: not searched yet ")
           }else{
               homeRecyleviewAdapter.fliteredList(filteredList)
           }
       }
    }

//    private fun fakeData():ArrayList<HomeData>{
//         DataRecyle = ArrayList<HomeData>()
//        DataRecyle.add(HomeData("one","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("two","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("three","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("four","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("five","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("six","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("seven","discriptionTest","meaning test"))
//        DataRecyle.add(HomeData("eight","discriptionTest","meaning test"))
//        return DataRecyle
//    }

    companion object {

    }
}