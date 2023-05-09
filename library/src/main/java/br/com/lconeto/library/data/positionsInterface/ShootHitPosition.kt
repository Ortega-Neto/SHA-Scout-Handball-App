package br.com.lconeto.library.data.positionsInterface

import java.io.Serializable

interface ShootHitPosition : Serializable {
    val outAboveOutLeft: Int
    val postOutLeft: Int
    val aboveOutLeft: Int
    val centerOutLeft: Int
    val belowOutLeft: Int
    val outAbovePostLeft: Int
    val postPostLeft: Int
    val abovePostLeft: Int
    val centerPostLeft: Int
    val belowPostLeft: Int
    val outAboveLeft: Int
    val postLeft: Int
    val aboveLeft: Int
    val centerLeft: Int
    val belowLeft: Int
    val outAboveCenter: Int
    val postCenter: Int
    val aboveCenter: Int
    val centerCenter: Int
    val belowCenter: Int
    val outAboveRight: Int
    val postRight: Int
    val aboveRight: Int
    val centerRight: Int
    val belowRight: Int
    val outAbovePostRight: Int
    val postPostRight: Int
    val abovePostRight: Int
    val centerPostRight: Int
    val belowPostRight: Int
    val outAboveOutRight: Int
    val postOutRight: Int
    val aboveOutRight: Int
    val centerOutRight: Int
    val belowOutRight: Int
}
