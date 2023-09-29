package validator

import piece.Piece
import Position

class Movement(private val piece : Piece, private val finalPosition : Position) {

    fun getPiece() : Piece {
        return piece
    }

    fun getFinalPosition() : Position {
        return finalPosition
    }
}