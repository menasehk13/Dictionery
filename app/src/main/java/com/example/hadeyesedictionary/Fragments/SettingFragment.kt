package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.navigation.findNavController
import com.example.hadeyesedictionary.R


class SettingFragment : Fragment() {
lateinit var gameButton:RelativeLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        gameButton.setOnClickListener(){
            it.findNavController().navigate(R.id.action_settingFragment_to_gameFragment)
        }
    }

    private fun initView(view: View) {
        gameButton=view.findViewById(R.id.gamebutton)
    }

    companion object {

    }
}