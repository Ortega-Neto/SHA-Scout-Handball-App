package br.com.lconeto.library.domain.helper.position

import br.com.lconeto.library.data.positionsInterface.PlayerPosition

class PositionHelperImpl : PositionHelper {
    private lateinit var positions: HashMap<PlayerPosition, Boolean>

    override fun initializePositionHashMap() {
        positions = hashMapOf(
            PlayerPosition.GOAL_KEEPER to false,
            PlayerPosition.LEFT_WING to false,
            PlayerPosition.PIVOT to false,
            PlayerPosition.RIGHT_WING to false,
            PlayerPosition.LEFT_BACK_COURT to false,
            PlayerPosition.RIGHT_BACK_COURT to false,
            PlayerPosition.CENTER_BACK_COURT to false
        )
    }

    override fun addPositionToHashMap(selectedPosition: PlayerPosition) {
        positions[selectedPosition] = true
    }

    override fun verifyPositionHashMap(): Boolean {
        positions.forEach {
            if (!it.value) return false
        }

        return true
    }
}
