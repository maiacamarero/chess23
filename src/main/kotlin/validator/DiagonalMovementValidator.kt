package src.validator

import Position
import board.Board
import java.lang.Math.abs

class DiagonalMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement) : Boolean {
        if (!board.isInBounds(movement.getFinalPosition())) {
            return false
        }
        // si las diferencias entre filas y columnas son iguales ⇒ es diagonal
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        val difRow : Int = abs(pieceActualPosition.getY() - movement.getFinalPosition().getY())
        val difCol : Int = abs(pieceActualPosition.getX() - movement.getFinalPosition().getX())
        return difRow == difCol
    }
}