package validator
import board.Board
import piece.Piece

class SameTeamValidator : Validator {

    override fun validateMovement(board: Board, movement: Movement): Boolean {
        val targetPiece: Piece? = board.getPiecesPositions().get(movement.getFinalPosition())
        if (targetPiece != null) {
            if (targetPiece.getPieceColor() == movement.getPiece().getPieceColor()) {
                return true
            }
        }
        return false
    }
}