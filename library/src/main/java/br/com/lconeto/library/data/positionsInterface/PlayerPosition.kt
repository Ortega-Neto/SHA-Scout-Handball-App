package br.com.lconeto.library.data.positionsInterface

import java.io.Serializable

enum class PlayerPosition(val value: String) : Serializable {
    GOAL_KEEPER("Goleiro"),
    LEFT_WING("Ponta Esquerda"),
    PIVOT("Pivô"),
    RIGHT_WING("Ponta Direita"),
    LEFT_BACK_COURT("Armador Esquerdo"),
    RIGHT_BACK_COURT("Armador Central"),
    CENTER_BACK_COURT("Armador Direito")
}
