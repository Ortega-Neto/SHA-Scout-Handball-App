package br.com.lconeto.library.domain.helper.position

import br.com.lconeto.library.data.positionsInterface.PlayerPosition

interface PositionHelper {
    fun initializePositionHashMap()
    fun addPositionToHashMap(selectedPosition: PlayerPosition)
    fun verifyPositionHashMap(): Boolean
}
