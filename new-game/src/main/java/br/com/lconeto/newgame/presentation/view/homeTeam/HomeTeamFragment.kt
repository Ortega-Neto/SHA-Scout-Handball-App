package br.com.lconeto.newgame.presentation.view.homeTeam

import br.com.lconeto.library.presentation.playersList.AbstractPlayersListFragment

class HomeTeamFragment : AbstractPlayersListFragment() {

    override fun onStart() {
        super.onStart()
        subscribeUi()
    }
    private fun subscribeUi() {
        finishedInsertingPlayers.observe(viewLifecycleOwner) {
            print("A")
        }
    }
}
