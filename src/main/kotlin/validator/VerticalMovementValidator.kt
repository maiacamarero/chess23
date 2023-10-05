package validator

import Position
import board.Board
import validator.results.FailureMovementResult
import validator.results.SuccessfulMovementResult
import validator.results.ValidatorResult

class VerticalMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): ValidatorResult {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        return if ((board.isInBounds(movement.getFinalPosition()) && (pieceActualPosition.getX() == movement.getFinalPosition().getX()))){
            SuccessfulMovementResult("Vertical movement successful")
        }else FailureMovementResult("Vertical movement failed")
    }
}