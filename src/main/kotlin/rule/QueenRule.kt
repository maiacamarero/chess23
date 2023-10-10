package rule
import board.Board
import rule.result.FailureRuleResult
import rule.result.SuccessfulRuleResult
import rule.result.RuleValidatorResult
import validator.Movement

class QueenRule : Rule {

    private val rookRule : Rule = RookRule()
    private val bishopRule : Rule = BishopRule()

    override fun isValidRule(board: Board, movement: Movement): RuleValidatorResult {
        return if (rookRule.isValidRule(board, movement)::class.simpleName == "SuccessfulMovementResult"){
            SuccessfulRuleResult("Cumple las reglas de la torre.")
        }else if (bishopRule.isValidRule(board, movement)::class.simpleName == "SuccessfulMovementResult"){
            SuccessfulRuleResult("Cumple las reglas del alfil.")
        }else FailureRuleResult("No cumple las reglas del alfil o de la torre")
    }
}
