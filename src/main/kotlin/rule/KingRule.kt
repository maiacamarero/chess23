
import board.Board
import src.validator.*
import validator.Movement

class KingRule : Rule {

    private val diagonalMovementValidator = DiagonalMovementValidator()
    private val verticalMovementValidator = VerticalMovementValidator()
    private val horizontalMovementValidator = HorizontalMovementValidator()
    private val sameTeamValidator = SameTeamValidator()
    private val limitKingMovementValidator = LimitKingMovementValidator()

    override fun isValidRule(board: Board, movement: Movement): Boolean {
        if (diagonalMovementValidator.validateMovement(board, movement) || verticalMovementValidator.validateMovement(board, movement)
            || horizontalMovementValidator.validateMovement(board, movement)
        ) {
            if (limitKingMovementValidator.validateMovement(board, movement)) {
                // come en las mismas direcciones en las que se mueve.
                if (!sameTeamValidator.validateMovement(board, movement)) {
                    return true
                }
                return false
            }
            // chequear si esta amenazado o si ya se movio, en cualquiera de estos casos no lo deja hacer el enroque
        }
        return false
    }
}
