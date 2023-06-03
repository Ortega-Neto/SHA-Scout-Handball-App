package br.com.lconeto.library.data.positionsInterface

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
enum class PlayerPosition(val value: String) : Parcelable {
    GOAL_KEEPER("Goleiro"),
    LEFT_WING("Ponta Esquerda"),
    PIVOT("Pivô"),
    RIGHT_WING("Ponta Direita"),
    LEFT_BACK_COURT("Armador Esquerdo"),
    CENTER_BACK_COURT("Armador Central"),
    RIGHT_BACK_COURT("Armador Direito")
}
