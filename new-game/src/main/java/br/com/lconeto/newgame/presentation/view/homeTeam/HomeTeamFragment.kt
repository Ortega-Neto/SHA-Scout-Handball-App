package br.com.lconeto.newgame.presentation.view.homeTeam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lconeto.library.presentation.BaseFragment
import br.com.lconeto.newgame.databinding.FragmentTeamBinding

class HomeTeamFragment : BaseFragment<FragmentTeamBinding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamBinding.inflate(inflater, container, false)
        return binding.root
    }
}
