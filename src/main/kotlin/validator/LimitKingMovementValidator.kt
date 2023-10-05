package validator

import Position
import board.Board
import validator.results.FailureMovementResult
import validator.results.SuccessfulMovementResult
import validator.results.ValidatorResult
import kotlin.math.abs

class LimitKingMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): ValidatorResult {
        val pieceActualPosition: Position = board.getPositionByPiece(movement.getPiece())
        val difRow: Int = pieceActualPosition.getY() - movement.getFinalPosition().getY()
        val difCol: Int = pieceActualPosition.getX() - movement.getFinalPosition().getX()
        return if (abs(difRow.toDouble()) <= 1 && abs(difCol.toDouble()) <= 1){
            SuccessfulMovementResult("King's move was successful")
        }else FailureMovementResult("King's move failed")
    }
}