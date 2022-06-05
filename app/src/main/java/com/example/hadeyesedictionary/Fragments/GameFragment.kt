package com.example.hadeyesedictionary.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.hadeyesedictionary.Helper.GameHelper
import com.example.hadeyesedictionary.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout


class GameFragment : Fragment() {
  private val args: GameFragmentArgs by navArgs()
    lateinit var textword:TextView
    lateinit var inputText:TextInputLayout
    lateinit var gameHelper: GameHelper
    lateinit var validate:MaterialButton
    lateinit var newGame:MaterialButton
    private var wordToFind: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameHelper= GameHelper(requireContext())
        gameHelper.addItemsFromJSON()
        initView(view)
        newGame()
        validate.setOnClickListener {
            validateanswer()
        }
        newGame.setOnClickListener {
            newGame()
        }

        when (args.mode) {
            "easy" -> {
                Toast.makeText(requireActivity(), "EASY", Toast.LENGTH_SHORT).show()
            }
            "hard" -> {
                Toast.makeText(requireActivity(), "Hard", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(requireActivity(), "someError Occured", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateanswer() {
        val w: String = inputText.editText!!.text.toString()
        if (gameHelper.words.contains(w)) {
            Toast.makeText(
                requireContext(),
                "Congratulations ! You found the word $wordToFind",
                Toast.LENGTH_SHORT
            ).show()
            newGame()
        } else {
            Toast.makeText(requireContext(), "Retry !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun newGame() {
        wordToFind = gameHelper.randomWord()
        val wordShuffled: String = gameHelper.correctAnswer(wordToFind!!)
        textword.text = wordShuffled
        inputText.editText!!.setText("")
    }

    private fun initView(view: View) {
        textword = view.findViewById(R.id.TextGame)
        inputText=view.findViewById(R.id.inputAnswer)
        newGame= view.findViewById(R.id.resetgame)
        validate =view.findViewById(R.id.validateAnswer)
    }

    companion object {

    }
}