package rule
import board.Board
import rule.result.FailureRuleResult
import rule.result.SuccessfulRuleResult
import rule.result.RuleValidatorResult
import validator.*

class BishopRule : Rule {

    private val diagonalMovementValidator = DiagonalMovementValidator()
    private val piecesInPathValidator = PiecesInPathValidator()
    private val sameColorValidator = SameColorValidator()

    override fun isValidRule(board: Board, movement: Movement): RuleValidatorResult {
        if (diagonalMovementValidator.validateMovement(board, movement)){
            if (sameColorValidator.validateMovement(board, movement)){
                return FailureRuleResult("No puede comer una pieza del mismo color.")
            }
            // el alfil no salta piezas
            return if (piecesInPathValidator.validateMovement(board, movement)){
                FailureRuleResult("El alfil no salta piezas")
            }else SuccessfulRuleResult("Movimiento valido")
        }
        return FailureRuleResult("No es movimiento diagonal.")
    }
}
