package validator

import Position
import board.Board
import validator.results.FailureMovementResult
import validator.results.SuccessfulMovementResult
import validator.results.ValidatorResult
import kotlin.math.abs

class DiagonalMovementValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement) : ValidatorResult {
        if (!board.isInBounds(movement.getFinalPosition())) {
            return FailureMovementResult("Position is out of bounds")
        }
        // si las diferencias entre filas y columnas son iguales ⇒ es diagonal
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        val difRow : Int = abs(pieceActualPosition.getY() - movement.getFinalPosition().getY())
        val difCol : Int = abs(pieceActualPosition.getX() - movement.getFinalPosition().getX())
        return if (difRow == difCol){
            SuccessfulMovementResult("Diagonal movement successful")
        }else FailureMovementResult("Diagonal movement failed")
    }
}