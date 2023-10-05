package validator

import Position
import board.Board
import validator.results.FailureMovementResult
import validator.results.SuccessfulMovementResult
import validator.results.ValidatorResult


class HorizontalMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): ValidatorResult {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        if (!board.isInBounds(movement.getFinalPosition())){
            return FailureMovementResult("Position is out of bounds")
        }
        return if( pieceActualPosition.getY() == movement.getFinalPosition().getY()){
            SuccessfulMovementResult("Horizontal movement successful")
        }else{
            FailureMovementResult("Horizontal movement fails")
        }
    }
}