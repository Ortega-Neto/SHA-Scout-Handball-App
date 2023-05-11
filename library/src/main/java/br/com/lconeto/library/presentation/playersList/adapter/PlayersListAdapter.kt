package br.com.lconeto.library.presentation.playersList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.lconeto.library.R
import br.com.lconeto.library.data.database.player.Player
import br.com.lconeto.library.data.positionsInterface.PlayerPosition
import br.com.lconeto.library.databinding.PlayersListItemBinding
import br.com.lconeto.library.domain.listener.PlayersListRecyclerViewClickListener

class PlayersListAdapter(
    private val players: List<Player>,
    private val listenerPlayersList: PlayersListRecyclerViewClickListener
) : RecyclerView.Adapter<PlayersListAdapter.PlayersListViewHolder>() {

    inner class PlayersListViewHolder(private val binding: PlayersListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            if (player.position == PlayerPosition.GOAL_KEEPER) {
                binding.constraintLayoutShirt.setBackgroundResource(R.drawable.ic_shirt_goal_keeper)
            }
            binding.textViewPlayerName.text = player.name
            binding.textViewPlayerNumber.text = player.number.toString()
            binding.textViewPlayerPosition.text = player.position.value
        }
    }

    override fun getItemCount() = players.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayersListViewHolder {
        val binding = PlayersListItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayersListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayersListViewHolder, position: Int) {
        holder.bind(players[position])

        holder.itemView.setOnClickListener {
            listenerPlayersList.onPlayerClickListener(
                players[position]
            )
        }
    }
}
