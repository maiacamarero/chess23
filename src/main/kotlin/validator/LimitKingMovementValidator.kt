package validator

import Position
import board.Board
import kotlin.math.abs

class LimitKingMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): Boolean {
        val pieceActualPosition: Position = board.getPositionByPiece(movement.getPiece())
        val difRow: Int = pieceActualPosition.getY() - movement.getFinalPosition().getY()
        val difCol: Int = pieceActualPosition.getX() - movement.getFinalPosition().getX()
        return (abs(difRow.toDouble()) <= 1 && abs(difCol.toDouble()) <= 1)
    }
}