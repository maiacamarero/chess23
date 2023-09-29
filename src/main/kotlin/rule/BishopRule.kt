
import board.Board
import src.validator.DiagonalMovementValidator
import src.validator.PiecesInPathValidator
import src.validator.Movement
import src.validator.SameTeamValidator

class BishopRule : Rule {

    private val diagonalMovementValidator = DiagonalMovementValidator()
    private val piecesInPathValidator = PiecesInPathValidator()
    private val sameTeamValidator = SameTeamValidator()

    override fun isValidRule(board: Board, movement: Movement): Boolean {
        if (diagonalMovementValidator.validateMovement(board, movement)){
            if (sameTeamValidator.validateMovement(board, movement)){
                return false
            }
            // el alfil no salta piezas
            if (!piecesInPathValidator.validateMovement(board, movement)){
                return true
            }
        }
        return false
    }
}
