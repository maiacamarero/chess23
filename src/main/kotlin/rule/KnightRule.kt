package rule
import Position
import validator.SameTeamValidator
import board.Board
import validator.Movement
import java.lang.Math.abs

class KnightRule : Rule {

    private val sameTeamValidator = SameTeamValidator()
    override fun isValidRule(board: Board, movement: Movement): Boolean {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        // el caballo se mueve 1 en filas y 2 en columnas o viceversa.
        val difRow : Int = abs(pieceActualPosition.getY() - movement.getFinalPosition().getY())
        val difCol : Int = abs(pieceActualPosition.getX() - movement.getFinalPosition().getX())
        if ((difRow == 1 && difCol == 2) || (difRow == 2 && difCol == 1)){
            // come siempre
            if (!sameTeamValidator.validateMovement(board, movement)){
                return true
            }
        }
        return false
    }

}
