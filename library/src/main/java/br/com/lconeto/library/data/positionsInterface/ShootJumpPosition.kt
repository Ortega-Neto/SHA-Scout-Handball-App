package br.com.lconeto.library.data.positionsInterface

import java.io.Serializable

interface ShootJumpPosition : Serializable {
    val leftWing: Int
    val leftPivot: Int
    val centerPivot: Int
    val rightPivot: Int
    val rightWing: Int
    val leftBackCourt: Int
    val centerBackCourt: Int
    val rightBackCourt: Int
    val penalty: Int
}
