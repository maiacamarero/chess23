package gameState

import Position
import piece.Piece
import piece.PieceColor

class NewGameState(private val piecesPositions : Map<Position, Piece>, private val nextColor : PieceColor) : GameState {

    fun getPiecesPositions() : Map<Position, Piece>{
        return piecesPositions
    }

    fun getColor() : PieceColor{
        return nextColor
    }
}