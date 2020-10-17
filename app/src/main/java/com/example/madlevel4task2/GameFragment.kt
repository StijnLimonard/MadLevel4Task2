package com.example.madlevel4task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game.*

/**
 * code for the rock paper scissors game
 */
class GameFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ivRockClick.setOnClickListener {
            playgame(1)
        }
        ivPaperClick.setOnClickListener {
            playgame(2)
        }
        ivScissorsClick.setOnClickListener {
            playgame(3)
        }
    }


    private fun playgame(playerchoice: Int){
        val computerChoice = (1..3).random()
        val result = checkWinner(playerchoice, computerChoice)
        updateUI(playerchoice, computerChoice, result)
    }

    private fun updateUI(playerchoice: Int, computerChoice: Int, result: String){
        tvWinner.text = result
        when (computerChoice){
            1 -> ivCPUresult.setImageResource(R.drawable.rock)
            2 -> ivCPUresult.setImageResource(R.drawable.paper)
            3 -> ivCPUresult.setImageResource(R.drawable.scissors)
        }
        when (playerchoice){
            1 -> ivYourresult.setImageResource(R.drawable.rock)
            2 -> ivYourresult.setImageResource(R.drawable.paper)
            3 -> ivYourresult.setImageResource(R.drawable.scissors)
        }
    }

    private fun checkWinner(playerchoice: Int, computerChoice: Int): String {
        return if(playerchoice == computerChoice){
            getString(R.string.draw)
        }else if ((playerchoice == 1 && computerChoice == 3)|| (playerchoice == 2 && computerChoice == 1) || (playerchoice == 3 && computerChoice == 2)){
            getString(R.string.you_win)
        }else{
            getString(R.string.you_lose)
        }
    }
}