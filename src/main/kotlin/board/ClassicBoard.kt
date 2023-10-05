package board

import Position
import exception.PieceNotFoundException
import piece.Piece

class ClassicBoard(private val sizeX : Int, private val sizeY : Int, private val piecesPositions : Map<Position, Piece>) : Board {

    //private val positions : List<Position>

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
        throw PieceNotFoundException("Piece not found")
    }

//    override fun getPositions(): List<Position> {
//        return positions
//    }
//
//    fun fillPositions() : List<Position>{
//        val positions1 : MutableList<Position> = mutableListOf()
//        for (i in 1..sizeX) {
//            for (j in 1..sizeY) {
//                positions1.add(Position(i, j))
//            }
//        }
//        return positions1.toList()
//    }
}