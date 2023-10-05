package validator
import board.Board
import piece.Piece
import validator.results.FailureMovementResult
import validator.results.SuccessfulMovementResult
import validator.results.ValidatorResult

class SameColorValidator : Validator {

    override fun validateMovement(board: Board, movement: Movement): ValidatorResult {
        val targetPiece: Piece? = board.getPiecesPositions().get(movement.getFinalPosition())
        if (targetPiece != null) {
            if (targetPiece.getPieceColor() == movement.getPiece().getPieceColor()) {
                return SuccessfulMovementResult("It's the same color" + targetPiece.getPieceColor().toString())
            }
        }
        return FailureMovementResult("It isn't the same color")
    }
}