package turnStrategy

import piece.PieceColor

interface TurnStrategy {
    fun advanceTurn() : TurnStrategy
    fun getCurrentColor() : PieceColor
}