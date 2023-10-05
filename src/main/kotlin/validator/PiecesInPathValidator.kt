package validator

import piece.Piece
import Position
import board.Board
import validator.results.FailureMovementResult
import validator.results.SuccessfulMovementResult
import validator.results.ValidatorResult
import kotlin.math.abs

class PiecesInPathValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): ValidatorResult {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        val difRow: Int = abs(pieceActualPosition.getY() - movement.getFinalPosition().getY())
        var path: Position
        for (i in 1..<difRow) {
            path = Position(
                pieceActualPosition.getX() + i * ((movement.getFinalPosition().getX() - pieceActualPosition.getX())
                        / difRow),
                pieceActualPosition.getY() + i * ((movement.getFinalPosition().getY() - pieceActualPosition.getY())
                        / difRow)
            )
            val pieceInPath : Piece? = board.getPiecesPositions().get(path)
            // si hay una pieza en el path devuelve true
            if (pieceInPath != null) {
                return SuccessfulMovementResult("There's a piece in the path")
            }
        }
        return FailureMovementResult("There's no pieces in the path")
    }
}