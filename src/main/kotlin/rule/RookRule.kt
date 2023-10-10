package rule
import board.Board
import piece.Piece
import rule.result.FailureRuleResult
import rule.result.SuccessfulRuleResult
import rule.result.RuleValidatorResult
import validator.*

class RookRule : Rule {

    private val verticalMovementValidator = VerticalMovementValidator()
    private val horizontalMovementValidator = HorizontalMovementValidator()
    private val piecesInPathValidator = PiecesInPathValidator()
    private val sameColorValidator = SameColorValidator()

    override fun isValidRule(board: Board, movement: Movement): RuleValidatorResult {
        val pieceTarget : Piece? = board.getPiecesPositions().get(movement.getFinalPosition())
        if (verticalMovementValidator.validateMovement(board, movement)
            || horizontalMovementValidator.validateMovement(board, movement)){
            if (pieceTarget != null){
                if (sameColorValidator.validateMovement(board, movement)){
                    return FailureRuleResult("No puede comer una pieza de su mismo equipo")
                }
                return SuccessfulRuleResult("Movimiento valido para comer")
            }
            if (piecesInPathValidator.validateMovement(board, movement)){
                return FailureRuleResult("No puede saltar piezas")
            }
            return SuccessfulRuleResult("Movimiento valido")
        }
        return FailureRuleResult("No corresponde a un movimiento vertical u horizontal")
    }
}
