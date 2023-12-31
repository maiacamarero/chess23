package board

import piece.Piece
import Position

interface Board {
    fun getSizeX() : Int
    fun getSizeY() : Int
    fun getPiecesPositions() : Map<Position, Piece>
    fun isInBounds(position: Position) : Boolean
    fun getPositionByPiece(piece: Piece) : Position
    fun getPositions() : List<Position>

    fun getPieceByPosition(position: Position) : Piece?
    fun getPosition(position: Position): Position
}