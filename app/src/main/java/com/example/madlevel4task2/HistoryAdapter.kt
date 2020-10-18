package com.example.madlevel4task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.model.Game
import kotlinx.android.synthetic.main.game_item.view.*

class HistoryAdapter(private val games: List<Game>): RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun databind(game:Game){
            when(game.result){
                "WIN" ->{
                    itemView.tvResult.text = "YOU WIN"
                }
                "LOSE" ->{
                itemView.tvResult.text = "YOU LOSE"
                }
                else->{
                    itemView.tvResult.text = game.result
                }
            }

            itemView.tvTime.text = game.date.toString()
            when(game.computerChoice.toInt()){
                1-> itemView.ivComputerResult.setImageResource(R.drawable.rock)
                2-> itemView.ivComputerResult.setImageResource(R.drawable.paper)
                3-> itemView.ivComputerResult.setImageResource(R.drawable.scissors)
            }
            when(game.playerMove.toInt()){
                1-> itemView.ivPlayerResult.setImageResource(R.drawable.rock)
                2-> itemView.ivPlayerResult.setImageResource(R.drawable.paper)
                3-> itemView.ivPlayerResult.setImageResource(R.drawable.scissors)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.game_item,parent, false))
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }

}