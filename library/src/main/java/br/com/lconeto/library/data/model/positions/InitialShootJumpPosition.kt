package br.com.lconeto.library.data.model.positions

import br.com.lconeto.library.data.positionsinterface.ShootJumpPosition

class InitialShootJumpPosition : ShootJumpPosition {
    override val leftWing: Int = 0
    override val leftPivot: Int = 0
    override val centerPivot: Int = 0
    override val rightPivot: Int = 0
    override val rightWing: Int = 0
    override val leftBackCourt: Int = 0
    override val centerBackCourt: Int = 0
    override val rightBackCourt: Int = 0
    override val penalty: Int = 0
}
