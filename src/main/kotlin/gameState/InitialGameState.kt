package gameState

import Position
import piece.Piece
import piece.PieceColor
import turnStrategy.TurnStrategy

class InitialGameState(private val boardSize : Int, private val piecesPositions : Map<Position, Piece>, private val color : TurnStrategy) {

    fun getPiecesPositions() : Map<Position, Piece>{
        return piecesPositions
    }

    fun getColor() : TurnStrategy{
        return color
    }

}
