package board

import piece.Piece
import Position
import exception.PieceNotFoundException

class ClassicBoard(private val sizeX : Int, private val sizeY : Int, private val piecesPositions : Map<Position, Piece>) : Board {

    override fun getX(): Int {
        return sizeX
    }

    override fun getY(): Int {
        return sizeY
    }

    override fun getPiecesPositions(): Map<Position, Piece> {
        return piecesPositions
    }

    override fun isInBounds(position: Position): Boolean {
        return (position.getX() in 1..sizeX) && (position.getY() in 1..sizeY)
    }

    override fun getPositionByPiece(piece: Piece) : Position{
        for (i in piecesPositions.keys){
            if (piece == piecesPositions[i]){
                return i
            }
        }
        throw PieceNotFoundException("piece.Piece not found")
    }
}