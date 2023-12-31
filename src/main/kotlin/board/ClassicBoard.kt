package board

import Position
import exception.PositionNotFoundException
import exception.PieceNotFoundException
import piece.Piece

class ClassicBoard(private val sizeX : Int, private val sizeY : Int, private val piecesPositions : Map<Position, Piece>, private val positions : List<Position> ) : Board {

    override fun getSizeX(): Int {
        return sizeX
    }

    override fun getSizeY(): Int {
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

    override fun getPieceByPosition(position: Position) : Piece {
        return piecesPositions[position]!!
    }

    override fun getPositions(): List<Position> {
        return positions
    }

    override fun getPosition(position: Position) : Position {
        for (i in positions){
            if (i.getX() == position.getX() && i.getY() == position.getY()){
                return i
            }
        }
        throw PositionNotFoundException("Position not found")
    }
}