package gameState

import Position
import exception.PositionNotFoundException
import piece.Piece
import piece.PieceColor

class NewGameState(private val piecesPositions : Map<Position, Piece>, private val nextColor : PieceColor, private val positions : List<Position>) : GameState {

    constructor() : this(mapOf(), PieceColor.WHITE, listOf())

    fun getPiecesPositions() : Map<Position, Piece>{
        return piecesPositions
    }

    fun getColor() : PieceColor{
        return nextColor
    }

    fun getPosition(position: Position) : Position{
        for (i in positions){
            if (i.getX() == position.getX() && i.getY() == position.getY()){
                return i
            }
        }
        throw PositionNotFoundException("Position not found")
    }
}