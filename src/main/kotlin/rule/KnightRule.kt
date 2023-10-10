package rule
import Position
import validator.SameColorValidator
import board.Board
import rule.result.FailureRuleResult
import rule.result.SuccessfulRuleResult
import rule.result.RuleValidatorResult
import validator.Movement
import kotlin.math.abs

class KnightRule : Rule {

    private val sameColorValidator = SameColorValidator()
    override fun isValidRule(board: Board, movement: Movement): RuleValidatorResult {
        val pieceActualPosition : Position = board.getPositionByPiece(movement.getPiece())
        // el caballo se mueve 1 en filas y 2 en columnas o viceversa.
        val difRow : Int = abs(pieceActualPosition.getY() - movement.getFinalPosition().getY())
        val difCol : Int = abs(pieceActualPosition.getX() - movement.getFinalPosition().getX())
        if ((difRow == 1 && difCol == 2) || (difRow == 2 && difCol == 1)){
            // come siempre
            if (!sameColorValidator.validateMovement(board, movement)){
                return SuccessfulRuleResult("Movimiento valido")
            }
        }
        return FailureRuleResult("No es un movimiento valido para el caballo")
    }

}
