package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.hadeyesedictionary.R


class GameFragment : Fragment() {
  private val args: GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.mode=="easy"){
            Toast.makeText(requireActivity(), "EASY", Toast.LENGTH_SHORT).show()
        }else if(args.mode=="hard"){
            Toast.makeText(requireActivity(), "Hard", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireActivity(), "someError Occured", Toast.LENGTH_SHORT).show()
        }
    }
    companion object {

    }
}