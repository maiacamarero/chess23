package validator

import Position
import board.Board

class VerticalMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): Boolean {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        return (board.isInBounds(movement.getFinalPosition()) && (pieceActualPosition.getX() == movement.getFinalPosition().getX()))
    }
}