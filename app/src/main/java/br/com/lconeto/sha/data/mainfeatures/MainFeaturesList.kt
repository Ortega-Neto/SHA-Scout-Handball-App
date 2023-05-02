package br.com.lconeto.sha.data.mainfeatures

import android.content.Context
import android.content.Intent
import br.com.lconeto.newgame.presentation.view.NewGameActivity
import br.com.lconeto.sha.R
import br.com.lconeto.sha.data.model.MainFeature

object MainFeaturesList {
    operator fun invoke(context: Context): List<MainFeature> {
        return listOf(
            getNewGameFeature(context),
            getMatchHistoryFeature(context)
        )
    }

    private fun getNewGameFeature(context: Context): MainFeature {
        return MainFeature(
            name = context.getString(R.string.new_game),
            icon = R.drawable.ic_new_game,
            intent = Intent(context, NewGameActivity::class.java)
        )
    }

    private fun getMatchHistoryFeature(context: Context): MainFeature {
        return MainFeature(
            name = context.getString(R.string.match_history),
            icon = R.drawable.ic_history,
            intent = Intent()
        )
    }
}
