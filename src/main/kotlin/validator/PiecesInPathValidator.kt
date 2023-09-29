package validator

import Piece
import Position
import board.Board
import src.validator.Validator
import java.lang.Math.abs

class PiecesInPathValidator : Validator {
    override fun validateMovement(board: Board, movement: Movement): Boolean {
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
                return true
            }
        }
        return false
    }
}