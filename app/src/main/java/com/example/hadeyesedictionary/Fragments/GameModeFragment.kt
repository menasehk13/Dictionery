package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.hadeyesedictionary.R
import com.google.android.material.button.MaterialButton


class GameModeFragment : Fragment() {
   lateinit var easyMode:MaterialButton
   lateinit var hardMode:MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_mode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        easyMode.setOnClickListener(){
          val bundle = Bundle()
            bundle.putString("mode","easy")
            it.findNavController().navigate(R.id.action_gameModeFragment_to_gameFragment,bundle)
          }
        hardMode.setOnClickListener(){
            val bundle = Bundle()
            bundle.putString("mode","hard")
            it.findNavController().navigate(R.id.action_gameModeFragment_to_gameFragment,bundle)
          }
    }

    private fun initView(view: View) {
        easyMode = view.findViewById(R.id.easy)
        hardMode = view.findViewById(R.id.hard)
    }

    companion object {

    }
}