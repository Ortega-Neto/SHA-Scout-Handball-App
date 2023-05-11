package br.com.lconeto.library.domain.listener

import br.com.lconeto.library.data.database.player.Player

interface PlayersListRecyclerViewClickListener {
    fun onPlayerClickListener(id: Int, player: Player)
}
