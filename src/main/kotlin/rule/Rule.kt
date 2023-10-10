package rule
import board.Board
import rule.result.RuleValidatorResult
import validator.Movement

interface Rule {
    fun isValidRule(board: Board, movement: Movement) : RuleValidatorResult

}
