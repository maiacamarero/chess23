package validator

import Position
import board.Board


class HorizontalMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): Boolean {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        if (!board.isInBounds(movement.getFinalPosition())){
            return false
        }
        return pieceActualPosition.getY() == movement.getFinalPosition().getY()
    }
}