package board

import Piece
import Position

interface Board {
    fun getX() : Int
    fun getY() : Int
    fun getPiecesPositions() : Map<Position, Piece>
    fun isInBounds(position: Position) : Boolean
    fun getPositionByPiece(piece: Piece) : Position
}