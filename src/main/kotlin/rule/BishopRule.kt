package rule
import validator.SameTeamValidator
import board.Board
import validator.DiagonalMovementValidator
import validator.PiecesInPathValidator
import validator.Movement

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
